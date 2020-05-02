package com.enigmacamp.JasaQ.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.AccountAddBalance;
import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.MitraDto;
import com.enigmacamp.JasaQ.dto.PaymentToMitra;
import com.enigmacamp.JasaQ.dto.TransactionDto;
import com.enigmacamp.JasaQ.dto.WithdrawMitraDto;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.Transaction;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.TransactionRepository;
import com.enigmacamp.JasaQ.utils.utilsDate;

@Service
public class TransactionServices {
		
	@Autowired
	TransactionRepository repo;
	
	@Autowired
	MitraServices mitraServ;
	
	@Autowired
	ClientServices clientServ;
	
	private utilsDate date = new utilsDate();
	
	public TransactionDto convertDto(Transaction tf) {
		ModelMapper modelMapper = new ModelMapper();
		TransactionDto dto = modelMapper.map(tf, TransactionDto.class);
		return dto;
	}
	
	public Transaction convertEntity(TransactionDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Transaction tf = modelMapper.map(dto, Transaction.class);
		return tf;
	}
	
	public TransactionDto getById(Long id) {
		Transaction tf = repo.findById(id).get();
		return convertDto(tf);
	}
	
	public void checkBalanceMitra(@Valid MitraDto dto) {
		if(dto.getSaldo()<0) {
			throw new NotFoundException("Saldo anda tidak mencukupi");
		}
	}
	
	public void checkBalanceClient(@Valid ClientDto clientDto, MitraDto mitraDto ) {
		if(clientDto.getSaldo()<mitraDto.getPriceServices()) {
			throw new NotFoundException("Balance anda tidak mencukupi");
		}
	}
	
	public String postBalance(@Valid AccountAddBalance request) {
		ClientDto dto = clientServ.getByUsernameIgnoreCase(request.getUsername());
		Client client = clientServ.convertClient(dto);
		clientServ.updateBalance(request);
		Transaction tf = new Transaction(date.dateNow(), request.getAmmount(), "Topup saldo", client);
		repo.save(tf);
		return "Topup saldo " + client.getSaldo() + " berhasil";
	}
	
	public TransactionDto payToMitra(@Valid PaymentToMitra payment) {
		ClientDto dtoClient = clientServ.getByUsernameIgnoreCase(payment.getUsernameClient());
		Client client = clientServ.convertClient(dtoClient);
		MitraDto dtoMitra = mitraServ.getByUsername(payment.getUsernameMitra());
		Mitra mitra = mitraServ.convertMitra(dtoMitra);
		this.checkBalanceClient(dtoClient, dtoMitra);
		clientServ.updateSubtract(client.getUsername(), mitra.getPriceServices());
		mitraServ.updateAdd(mitra.getUsername(), mitra.getPriceServices());
		Transaction tf = new Transaction(date.dateNow(), mitra.getPriceServices(), "Services " + mitra.getServicesMitra().getServicesName(), client, mitra);
		repo.save(tf);
		TransactionDto dto = new TransactionDto(tf.getDate(), tf.getPrice(), tf.getDescription());
		return dto;
	}
	
	public void deleteById(@Valid Long id) {
		repo.deleteById(id);
	}
	
	public void withDraw(@Valid WithdrawMitraDto withdraw) {
		MitraDto dtoMitra = mitraServ.getByUsername(withdraw.getUsername());
		Mitra mitra = mitraServ.convertMitra(dtoMitra);
		if(dtoMitra.getSaldo() < withdraw.getAmmount()) {
			throw new NotFoundException("Saldo tidak cukup");
		}
		mitraServ.updateSubstract(dtoMitra.getUsername(), withdraw.getAmmount());
		Transaction tf = new Transaction(date.dateNow(), withdraw.getAmmount(), "Transfer saldo", mitra);
		repo.save(tf);
	}
	
	public List<Transaction> getAll() {
		return repo.findAll();
	}
	
	public List<Transaction> getListTransactionByMitra(@Valid String mitraUsername) {
		MitraDto dtoMitra = mitraServ.getByUsername(mitraUsername);
		Mitra mitra = mitraServ.convertMitra(dtoMitra);
		List<Transaction> tf = repo.findByTransactionMitra(mitra);
		return tf;
	}
	
	public List<Transaction> getListTransactionByClient(@Valid String clientUsername) {
		ClientDto dtoClient = clientServ.getByUsernameIgnoreCase(clientUsername);
		Client client = clientServ.convertClient(dtoClient);
		List<Transaction> tf = repo.findByTransactionClient(client);
		return tf;
	}
}
