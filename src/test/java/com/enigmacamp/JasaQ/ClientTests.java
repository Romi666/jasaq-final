package com.enigmacamp.JasaQ;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.enigmacamp.JasaQ.dto.AccountAddBalance;
import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.ClientRequest;
import com.enigmacamp.JasaQ.dto.ClientUpdateProfile;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.ClientRepository;
import com.enigmacamp.JasaQ.services.ClientServices;

@RunWith(SpringRunner.class)
public class ClientTests {

	@TestConfiguration
	static class ClientServicesContextConfiguration {
		@Bean
		public ClientServices clientServices() {
			return new ClientServices();
		}
	}
	
	@Autowired
	private ClientServices services;
	
	@MockBean
	private ClientRepository repo;
	
	@Before
	public void setup() throws NotFoundException {
		Client client = new Client("JasaQTest", "jasaQ", "123123", "photo", "romi@jasaQ.net", "08128384852", "Jln Nadare 12 Jaksel", 10000.0);
		ClientDto dtoClient = new ClientDto("JasaQTest", "jasaQ", "123123", "photo", "romi@jasaQ.net", "08128384852", "Jln Nadare 12 Jaksel", 10000.0);
		List<Client> clientDtos = new ArrayList<Client>();
		clientDtos.add(client);
		Mockito.when(repo.findByUsername("jasaQ")).thenReturn(client);
		Mockito.when(repo.findByUsernameContainsIgnoreCase("jasaq")).thenReturn(client);
		Mockito.when(repo.findAll()).thenReturn(clientDtos);
	}
	
	@Test
	public void whenFindByUsernameIgnoreCase_returnClient() throws NotFoundException {
		assertEquals(services.getByUsernameIgnoreCase("jasaQ").getUsername(), "jasaQ");
	}
	
	@Test
	public void whenCreateClient_returnSave() {
		ClientDto dtoClient = new ClientDto("JasaQTest", "jasaQ", "123123", "photo", "romi@jasaQ.net", "08128384852", "Jln Nadare 12 Jaksel", 10000.0);
		services.convertClient(dtoClient);
		assertEquals(services.create(new ClientRequest("romi", "romi", "123123", "photo", "jasaQ@jasaQ.net", "08082828324", "Jln Akara 23 Jaksel")).getUsername(), "romi");
	}
	
	@Test
	public void whenGetByUsername_returnClient() throws NotFoundException {
		assertEquals(services.getByUsername("jasaQ", "123123").getUsername(), "jasaQ");
	}
	
	@Test
	public void whenGetAll_returnClientDtos() throws NotFoundException {
		assertEquals(services.getAll().size(), 1);
	}
	
	@Test
	public void whenUpdateBalance_returnSaldo() throws NotFoundException {
		assertEquals(services.updateBalance(new AccountAddBalance("jasaQ", 2000.0)), "Saldo anda "+12000.0);
	}
	
	@Test
	public void whenUpdateProfile_returnProfile() throws NotFoundException {
		assertEquals(services.updateProfile(new ClientUpdateProfile("test", "jasaQ", "123123", "080808080808", "read@alwar", "Jlnjln")).getUsername(), "jasaQ");
	}
	
}
