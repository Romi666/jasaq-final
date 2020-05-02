package com.enigmacamp.JasaQ.controller;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.enigmacamp.JasaQ.dto.MitraDto;
import com.enigmacamp.JasaQ.dto.MitraRequest;
import com.enigmacamp.JasaQ.dto.MitraSetServicesType;
import com.enigmacamp.JasaQ.dto.MitraUpdateProfile;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.exceptions.CustomErrorResponse;
import com.enigmacamp.JasaQ.services.MitraServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("mitra")
@Validated
@CrossOrigin(origins = "*")
public class MitraController {
	@Autowired
	MitraServices services;
	
	@ApiOperation(value = "create")
	@PostMapping("")
	public MitraDto create(@Valid @RequestBody MitraRequest request) {
		return services.create(request);
	}
	
	@ApiOperation(value = "login mitra")
	@GetMapping("/login")
	public MitraDto loginMitra(@Valid @RequestParam String username, String password) {
		return services.getMitraByUsernameAndPassword(username, password);
	}
	
	@ApiOperation(value = "Get all mitra")
	@GetMapping("")
	public List<Mitra> getAll(){
		return services.getAll();
	}
	
	@ApiOperation(value = "Get by services mitra")
	@GetMapping("/byService")
	public List<Mitra> getByServicesMitra(@Valid @RequestParam String name){
		return services.getByServicesMitra(name);
	}
	
	@ApiOperation(value = "Delete Mitra")
	@DeleteMapping("")
	public void deleteById(@Valid @RequestParam Long id) {
		services.deleteById(id);
	}
	
	@ApiOperation(value = "Update profile")
	@PutMapping("/UpdateProfile")
	public MitraDto updateProfile(@Valid @RequestBody MitraUpdateProfile request) {
		return services.updateMitra(request);
	}
	
	@GetMapping(value = "/barbecue/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage barbecueEAN13Barcode(@PathVariable("barcode") String barcode)
    throws Exception {
        return (services.generateEAN13BarcodeImage(barcode));
    }
	
	@ApiOperation(value = "Get by id")
	@GetMapping("/getById")
	public MitraDto getById(@Valid @RequestParam Long id ) {
		return services.getById(id);
	}
	
	@ApiOperation(value = "Set services")
	@PutMapping("/SetServicesMitra")
	public CustomErrorResponse setServicesMitra(@Valid @RequestBody MitraSetServicesType request,UriComponentsBuilder builder,
			HttpServletRequest req) {
		services.SetServicesMitraReq(request);
		String path = req.getRequestURI();
		CustomErrorResponse message = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK.value(),
				"Set Services success ", path);
		return message;
	}
}
