package com.enigmacamp.JasaQ.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.MitraDto;
import com.enigmacamp.JasaQ.dto.RequestFormClient;
import com.enigmacamp.JasaQ.dto.RequestFormDto;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.RequestForm;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.RequestFormRepository;

@Service
public class RequestFormServices {
	@Autowired
	RequestFormRepository repo;
	
	@Autowired
	MitraServices mitraServices;
	
	@Autowired
	ClientServices clientServices;
	
	public RequestFormDto convertDto(@Valid RequestForm requestForm) {
		ModelMapper modelMapper = new ModelMapper();
		RequestFormDto dto = modelMapper.map(requestForm, RequestFormDto.class);
		return dto;
	}
	
	public RequestForm convertEntity(@Valid RequestFormDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		RequestForm requestForm = modelMapper.map(dto, RequestForm.class);
		return requestForm;
	}
	
	public RequestFormDto create(@Valid RequestFormClient request) {
		ClientDto clientDto = clientServices.getByUsernameIgnoreCase(request.getSender());
		MitraDto mitraDto = mitraServices.getByUsername(request.getReceiver());
		Client client = clientServices.convertClient(clientDto);
		Mitra mitra = mitraServices.convertMitra(mitraDto);
		RequestForm newForm = new RequestForm(request.getBookingDate(), request.getDescription(), mitra, client, "Belum dibayar");
		repo.save(newForm);
		return convertDto(newForm);
	}
	
	public RequestFormDto getById(@Valid Long id) {
		RequestForm reqForm = repo.findById(id).get();
		return convertDto(reqForm);
	}
	
	public String updateStatusPembayaran(@Valid Long id) {
		RequestForm requestForm = repo.findById(id).get();
		requestForm.setStatusPembayaran("Sudah dibayar");
		repo.save(requestForm);
		return requestForm.getStatusPembayaran();
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public List<RequestForm> findAll() {
		return repo.findAll();
	}
	
	@SuppressWarnings("unused")
	public List<RequestForm> findByMitra(@Valid String username) {
		List<RequestForm> listAll = repo.findAll();
		List<RequestForm> newList = new ArrayList<RequestForm>();
		MitraDto mitraDto = mitraServices.getByUsername(username);
		Mitra mitra = mitraServices.convertMitra(mitraDto);
		for (RequestForm requestForm : listAll) {
			if(requestForm.getReceiver().getUsername().equals(mitra.getUsername()) && requestForm.getStatusPembayaran().equalsIgnoreCase("Belum dibayar")) {
				newList.add(requestForm);
			}
		}
		if(newList==null) {
			throw new NotFoundException("Belum ada request dari client");
		}
		return newList;
	}
	
	@SuppressWarnings("unused")
	public List<RequestForm> findByClient(String username) {
		List<RequestForm> listAll = repo.findAll();
		List<RequestForm> newList = new ArrayList<RequestForm>();
		ClientDto clientDto = clientServices.getByUsernameIgnoreCase(username);
		Client client = clientServices.convertClient(clientDto);
		for (RequestForm requestForm : listAll) {
			if(requestForm.getSender().getUsername().equalsIgnoreCase(client.getUsername())&& requestForm.getStatusPembayaran().equalsIgnoreCase("Belum dibayar")) {
				newList.add(requestForm);
			}
			
		}
		if(newList==null) {
			throw new NotFoundException("Belum ada form request");
		}
		return newList;
	}
}
