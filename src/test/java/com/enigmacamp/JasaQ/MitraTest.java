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

import com.enigmacamp.JasaQ.dto.MitraRequest;
import com.enigmacamp.JasaQ.dto.MitraUpdateProfile;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.enums.Status;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.MitraRepository;
import com.enigmacamp.JasaQ.services.MitraServices;
import com.enigmacamp.JasaQ.services.MitraServicesServices;

@RunWith(SpringRunner.class)
public class MitraTest {
	
	@TestConfiguration
	static class MitraServicesContextConfiguration{
		@Bean
		public MitraServices mitraServices() {
			return new MitraServices();
		}
	}
	
	@Autowired
	private MitraServices services;
	
	@MockBean
	private MitraServicesServices mitraServ;
	
	@MockBean
	private MitraRepository repo;
	
	@Before
	public void setup() throws NotFoundException {
		
		ServicesMitra servMitra= new ServicesMitra(1L, "AC", "logo");
		List<ServicesMitra> listServMitra = new ArrayList<ServicesMitra>();
		listServMitra.add(servMitra);
		
		Mitra mitra = new Mitra("MitraTest", "mitraTest", "123123", "test", "photoProfile", Status.AVAILABLE, "08", "Jlan qwerqw", 0.0, Role.MITRA, 1000.0);
		List<Mitra> mitraDtos = new ArrayList<Mitra>();
		mitraDtos.add(mitra);
		Mockito.when(repo.findByUsername("mitraTest")).thenReturn(mitra);
		Mockito.when(repo.findByNameContainsIgnoreCase("MitraTest")).thenReturn(mitra);
		Mockito.when(repo.findAll()).thenReturn(mitraDtos);
	}
	
	
	@Test
	public void whenFindByUsername_returnMitra() {
		assertEquals(services.getByUsername("mitraTest").getUsername(), "mitraTest");
	}
	
	@Test 
	public void whenCreateMitra_returnSave() throws NotFoundException {
		assertEquals(services.create(new MitraRequest("mitra", "mitraaa", "123123", "mitra@mitra.net", "mitramitra", "0812838428", "asd", "AC", 20000.0)).getServicesMitra().getServicesName(), "AC" );
	}
	
	@Test
	public void whenGetAll_returnMitraDtos() throws NotFoundException {
		assertEquals(services.getAll().size(), 1);
	}
	
	@Test
	public void whenGetbyUsernameAndPassword_returnMitra() throws NotFoundException {
		assertEquals(services.getMitraByUsernameAndPassword("mitraTest", "123123").getUsername(), "mitraTest");
	}
	
	@Test
	public void whenMitraUpdateProfile_returnUpdate() throws NotFoundException {
		services.updateSubstract("mitraTest", 1000.0);
		services.updateAdd("mitraTest", 1000.0);
		services.updateBalance("mitraTest", 1000.0);
		assertEquals(services.updateMitra(new MitraUpdateProfile("Mitra", "mitraTest", "123123", "08", 1000.0, "AWD")).getUsername(), "mitraTest");
	}
	
	@Test
	public void whenGetByServicesMitra_returnList() throws NotFoundException {
		assertEquals(services.getByServicesMitra("AC").size(), null);
	}

}
