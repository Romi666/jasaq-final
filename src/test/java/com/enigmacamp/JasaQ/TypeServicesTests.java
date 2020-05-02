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

import com.enigmacamp.JasaQ.dto.TypeServicesDto;
import com.enigmacamp.JasaQ.dto.TypeServicesRequest;
import com.enigmacamp.JasaQ.entity.TypeServices;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.TypeServicesRepository;
import com.enigmacamp.JasaQ.services.TypeServicesServices;

@RunWith(SpringRunner.class)
public class TypeServicesTests {
	
	@TestConfiguration
	static class TypeServicesContextConfiguration {
		@Bean
		public TypeServicesServices typeServices() {
			return new TypeServicesServices();
		}
	}
	
	@Autowired
	private TypeServicesServices services;
	
	@MockBean
	private TypeServicesRepository repo;
	
	@Before
	public void setup() throws NotFoundException {
		TypeServices type = new TypeServices(1L,"AC");
		TypeServicesDto dtoType = new TypeServicesDto("AC");
		List<TypeServices> dtos = new ArrayList<TypeServices>();
		dtos.add(type);
		
		Mockito.when(repo.findByTypeContainsIgnoreCase("AC")).thenReturn(type);
		Mockito.when(repo.findAll()).thenReturn(dtos);
	}
	
	@Test
	public void findByTypeContainsIgnoreCase_returnType() throws NotFoundException {
		TypeServicesDto type = new TypeServicesDto("Kulkas");
		services.convertEntity(type);
		assertEquals(services.findByTypeContainsIgnoreCase("AC").getType(), "AC");
	}
	
	@Test
	public void whenCreateType_returnSave() throws NotFoundException {
		assertEquals(services.create(new TypeServicesRequest("Lemari")).getType(), "Lemari");
	}
	
	@Test
	public void whenGetAll_returnDtos()throws NotFoundException {
		assertEquals(services.getAll().size(), 1);
	}
	
	@Test
	public void whenFindById_returnAC() throws NotFoundException {
		assertEquals(services.findById(1L), "AC");
	}
}
