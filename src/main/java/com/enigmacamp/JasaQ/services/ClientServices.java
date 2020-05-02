package com.enigmacamp.JasaQ.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.AccountAddBalance;
import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.ClientRequest;
import com.enigmacamp.JasaQ.dto.ClientUpdateProfile;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.ClientRepository;

@Service
public class ClientServices {
	@Autowired
	ClientRepository repo;
	
	
	public ClientDto convertClientDto(Client client) {
		ModelMapper modelMapper = new ModelMapper();
		ClientDto dto = modelMapper.map(client, ClientDto.class);
		return dto;
	}
	
	public Client convertClient(ClientDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Client client = modelMapper.map(dto, Client.class);
		return client;
	}
	
	public ClientDto create(ClientRequest request) {
		Client check = repo.findByUsername(request.getUsername());
		if(check!=null) {
			throw new NotFoundException("Username is already exist");
		}
		Client client = new Client(request.getName(), request.getUsername(), request.getPassword(), request.getPhotoProfile(), request.getEmail(), request.getNoHp(), request.getAlamat(), 0.0, Role.CLIENT);
		ClientDto dto = convertClientDto(client);
		repo.save(client);
		return dto;
	}
	
	public ClientDto findById(Long id) {
		Client client = repo.findById(id).get();
		return convertClientDto(client);
	}
	
	public ClientDto getByUsername(String username, String password) {
		List<Client> client = repo.findAll();
		Client client1 = null;
		if(username==null || password==null) {
			throw new NotFoundException("username dan password harus diisi");
		}
		for (Client client2 : client) {
			if(client2.getUsername().equals(username)&& client2.getPassword().equals(password)) {
				client1 = client2;
				
			}
		}
		return convertClientDto(client1);
	}
	
	
	public List<Client> getAll(){
		return repo.findAll();
	}
	
	public ClientDto getByUsernameIgnoreCase(String username) {
		Client client = repo.findByUsername(username);
		return convertClientDto(client);
	}
	
	public String updateBalance(AccountAddBalance request) {
		Client client = repo.findByUsername(request.getUsername());
		client.setSaldo(client.getSaldo()+request.getAmmount());
		repo.save(client);
		return "Saldo anda " + client.getSaldo();
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	
	public ClientDto updateProfile(ClientUpdateProfile request) {
		Client client = repo.findByUsername(request.getUsername());
		client.setName(request.getName());
		client.setPassword(request.getPassword());
		client.setEmail(request.getEmail());
		client.setAlamat(request.getAlamat());
		client.setNoHp(request.getNoHp());
		repo.save(client);
		return convertClientDto(client);
	}
	
	public void updateSubtract(String username, Double ammount) {
		Client client = repo.findByUsername(username);
		client.setSaldo(client.getSaldo()-ammount);
		repo.save(client);
	}

}
