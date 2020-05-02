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

import com.enigmacamp.JasaQ.dto.RequestFormDto;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.RequestForm;
import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.enums.Status;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;

import com.enigmacamp.JasaQ.repository.RequestFormRepository;
import com.enigmacamp.JasaQ.services.ClientServices;
import com.enigmacamp.JasaQ.services.MitraServices;
import com.enigmacamp.JasaQ.services.RequestFormServices;

@RunWith(SpringRunner.class)
public class RequestFormTest {
	
	@TestConfiguration
	static class RequestFormServicesContextConfiguration {
		@Bean
		public RequestFormServices requestFormServices() {
			return new RequestFormServices();
		}
	}
		
		@Autowired
		private RequestFormServices services;
		
		@MockBean
		private RequestFormRepository repo;
		
		@MockBean
		private ClientServices clientServ;
		
		@MockBean
		private MitraServices mitraServ;
		
		@Before
		public void setup() throws NotFoundException {
			Client client = new Client(1L, "Test", "test", "password", "photo", "test@gmaik.com", "080808023242", "Alamat kamis a", 0.0);
			List<Client> clientList = new ArrayList<Client>();
			clientList.add(client);
	
			Mitra mitra = new Mitra("MitraA", "mitratest", "password", "email@galra", "photo", Status.AVAILABLE, "08080992949", "ALamat alamatawek", 0.0, Role.MITRA, 0.0);
			List<Mitra> mitraList = new ArrayList<Mitra>();
			mitraList.add(mitra);
			
			RequestForm requestForm = new RequestForm("2020-5-26", "Services", mitra, client, "Belum dibayar");
			List<RequestForm> requestList = new ArrayList<RequestForm>();
			requestList.add(requestForm);
			Mockito.when(repo.findAll()).thenReturn(requestList);
		}
	
	
	@Test
	public void whenGetAll_returnRequestList() throws NotFoundException {
		RequestFormDto dtos = new RequestFormDto();
		RequestForm entity = new RequestForm();
		services.convertDto(entity);
		services.convertEntity(dtos);
		assertEquals(services.findAll().size(), 1);
	}

}
