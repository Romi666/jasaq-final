package com.enigmacamp.JasaQ.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigmacamp.JasaQ.dto.TypeServicesDto;
import com.enigmacamp.JasaQ.dto.TypeServicesRequest;
import com.enigmacamp.JasaQ.entity.TypeServices;
import com.enigmacamp.JasaQ.services.TypeServicesServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("type")
@Validated
@CrossOrigin(origins = "*")
public class typeServicesController {
	@Autowired
	TypeServicesServices services;
	
	@ApiOperation(value = "Create type")
	@PostMapping("")
	public TypeServicesDto create(@Valid @RequestBody TypeServicesRequest request) {
		return services.create(request);
	}
	
	@ApiOperation(value = "Get All")
	@GetMapping("")
	public List<TypeServices> getAll() {
		return services.getAll();
	}
	
	@ApiOperation(value = "Get by type")
	@GetMapping("/search")
	public TypeServicesDto getByType(@Valid @RequestParam String type) {
		return services.findByTypeContainsIgnoreCase(type);
	}
	
	@ApiOperation(value = "Get by id")
	@GetMapping("/id")
	public Optional<TypeServices> getById(@Valid @RequestParam Long id) {
		return services.findById(id);
	}
	
	@ApiOperation(value = "Delete Type Services")
	@DeleteMapping("")
	public void delete(@Valid @RequestParam Long id) {
		services.deleteById(id);
	}
	
}