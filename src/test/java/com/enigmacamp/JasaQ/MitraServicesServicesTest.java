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

import com.enigmacamp.JasaQ.dto.ServiceMitraDto;
import com.enigmacamp.JasaQ.dto.ServicesMitraRequest;
import com.enigmacamp.JasaQ.dto.TypeServicesDto;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.entity.TypeServices;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.ServicesMitraRepository;
import com.enigmacamp.JasaQ.services.MitraServicesServices;
import com.enigmacamp.JasaQ.services.TypeServicesServices;

@RunWith(SpringRunner.class)
public class MitraServicesServicesTest {
	
	@TestConfiguration
	static class MitraServicesServicesContextConfiguration {
		@Bean
		public MitraServicesServices mitraServ() {
			return new MitraServicesServices();
		}
	}
	
	@Autowired
	private MitraServicesServices mitraServ;
	
	@MockBean
	ServicesMitraRepository repo;
	
	@MockBean
	TypeServicesServices typeServices;
	
	@Before
	public void setup() throws NotFoundException {
		TypeServices type = new TypeServices(1L,"Elektronik");
		TypeServicesDto dtoType = new TypeServicesDto("Elektonik");
		List<TypeServices> dtos = new ArrayList<TypeServices>();
		dtos.add(type);
		
		Mockito.when(typeServices.findByTypeContainsIgnoreCase("Elektronik")).thenReturn(dtoType);
		Mockito.when(typeServices.getAll()).thenReturn(dtos);
		
		ServicesMitra servMitra = new ServicesMitra("AC", "logo", type);
		ServiceMitraDto dtoServMitra = new ServiceMitraDto("AC", "logo", dtoType);
		List<ServicesMitra> servMitraList = new ArrayList<ServicesMitra>();
		servMitraList.add(servMitra);
		
		Mockito.when(mitraServ.getAll()).thenReturn(servMitraList);
		Mockito.when(mitraServ.getByType("Elektronik")).thenReturn(servMitraList);
		Mockito.when(mitraServ.getByName("AC")).thenReturn(dtoServMitra);
	}
	
	@Test
	public void whenGetyByName_returnMitraDto(){
		assertEquals(mitraServ.getByType("Elektronik").size(), 1);
		
	}
	
	@Test
	public void whenCreateServices_returnSave(){
		mitraServ.deleteById(1L);
		assertEquals(mitraServ.create(new ServicesMitraRequest("AC", "logo", "Elektronik")), "save");
	}
}
