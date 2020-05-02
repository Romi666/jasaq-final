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

import com.enigmacamp.JasaQ.dto.RequestFormClient;
import com.enigmacamp.JasaQ.dto.RequestFormDto;
import com.enigmacamp.JasaQ.entity.RequestForm;
import com.enigmacamp.JasaQ.services.RequestFormServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("requestForm")
@Validated
@CrossOrigin(origins = "*")
public class RequestFormController {
	@Autowired
	RequestFormServices services;
	
	@ApiOperation(value = "create request")
	@PostMapping("")
	public RequestFormDto create(@Valid @RequestBody RequestFormClient request) {
		return services.create(request);
	}
	
	@ApiOperation(value = "delete request")
	@DeleteMapping("")
	public void delete(@Valid @RequestParam Long id) {
		services.deleteById(id);
	}
	
	@ApiOperation(value = "find All")
	@GetMapping("/getAll")
	public List<RequestForm> findAll() {
		return services.findAll();
	}
	
	@ApiOperation(value = "Get by mitra")
	@GetMapping("/getByMitra")
	public List<RequestForm> findByMitra(@Valid @RequestParam String username) {
		return services.findByMitra(username);
	}
	
	@ApiOperation(value = "Set status pembayaran")
	@PutMapping("/") 
	public String setStatusPembayaran(@Valid @RequestParam Long id) {
		return services.updateStatusPembayaran(id);
	}
	
	@ApiOperation(value = "Get by client")
	@GetMapping("getByClient")
	public List<RequestForm> findByClient(@Valid @RequestParam String username){
		return services.findByClient(username);
	}
	
	@ApiOperation(value = "Get by id")
	@GetMapping("getById")
	public RequestFormDto getById(@Valid @RequestParam Long id) {
		return services.getById(id);
	}
}
