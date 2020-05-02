package com.enigmacamp.JasaQ.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigmacamp.JasaQ.dto.AccountAddBalance;
import com.enigmacamp.JasaQ.dto.ClientDto;
import com.enigmacamp.JasaQ.dto.ClientRequest;
import com.enigmacamp.JasaQ.dto.ClientUpdateProfile;
import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.services.ClientServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("client")
@Validated
@CrossOrigin(origins = "*")
public class clientController {
	@Autowired
	ClientServices services;
	
	@ApiOperation(value = "Get all user")
	@GetMapping("")
	public List<Client> getAll() {
		return services.getAll();
	}
	
	@ApiOperation(value = "Get by username")
	@GetMapping("search")
	public ClientDto getByUsername(@Valid @RequestParam String username, String password) {
		return services.getByUsername(username, password);
	}
	
	@ApiOperation(value = "Create client")
	@PostMapping
	public ClientDto create(@Valid @RequestBody ClientRequest request) {
		return services.create(request);
	}
	
	@ApiOperation(value = "Add balance")
	@PutMapping("/addBalance")
	public String AddBalance(@Valid @RequestBody AccountAddBalance request) {
		return services.updateBalance(request);
	}
	
	@ApiOperation(value = "Delete Client")
	@DeleteMapping("")
	public void delete(Long id) {
		services.deleteById(id);
	}
	
	@ApiOperation(value = "Update profile")
	@PutMapping("/UpdateProfile")
	public ClientDto updateProfile(@Valid @RequestBody ClientUpdateProfile request) {
		return services.updateProfile(request);
	}
	
	@ApiOperation(value = "Get By id")
	@GetMapping("/byId")
	public ClientDto getById(@Valid @RequestParam Long id) {
		return services.findById(id);
	}
}
