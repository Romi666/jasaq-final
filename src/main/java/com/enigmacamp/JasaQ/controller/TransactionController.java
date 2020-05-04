package com.enigmacamp.JasaQ.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.enigmacamp.JasaQ.dto.AccountAddBalance;
import com.enigmacamp.JasaQ.dto.PaymentToMitra;
import com.enigmacamp.JasaQ.dto.TransactionDto;
import com.enigmacamp.JasaQ.dto.WithdrawMitraDto;
import com.enigmacamp.JasaQ.entity.Transaction;
import com.enigmacamp.JasaQ.exceptions.CustomErrorResponse;
import com.enigmacamp.JasaQ.services.TransactionServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("transaction")
@Validated
@CrossOrigin(origins = "*")
public class TransactionController {
	@Autowired
	TransactionServices services;
	
	@ApiOperation(value = "Add balance")
	@PostMapping("")
	public CustomErrorResponse PostBalance(@Valid @RequestBody AccountAddBalance request,UriComponentsBuilder builder,
			HttpServletRequest req) {
		services.postBalance(request);
		String path = req.getRequestURI();
		CustomErrorResponse message = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK.value(),
				"add balance success ", path);
		return message;
	}
	
	@ApiOperation(value = "Payment to mitra")
	@PostMapping("/pembayaran")
	public TransactionDto Payment(@Valid @RequestBody PaymentToMitra payment) {
		return services.payToMitra(payment);
	}
	
	@ApiOperation(value = "Delete Transaction")
	@DeleteMapping("")
	public void delete(@Valid @RequestParam Long id) {
		services.deleteById(id);
	}
	
	@ApiOperation(value = "Get list from Mitra ")
	@GetMapping("/GetListFromMitra")
	public List<Transaction> findByMitra(@Valid @RequestParam String usernameMitra) {
		return services.getListTransactionByMitra(usernameMitra);
	}
	
	@ApiOperation(value = "Get list from Client")
	@GetMapping("/GetLisFromClient")
	public List<Transaction> findByClient(@Valid @RequestParam String usernameClient) {
		return services.getListTransactionByClient(usernameClient);
	}
	
	@ApiOperation(value = "Withdraw saldo")
	@PostMapping("/Withdraw")
	public CustomErrorResponse withdrawBalance(@Valid @RequestBody WithdrawMitraDto withdraw,UriComponentsBuilder builder,
			HttpServletRequest req) {
		services.withDraw(withdraw);
		String path = req.getRequestURI();
		CustomErrorResponse message = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK.value(), "Sukses withdraw", path);
		return message;
	}
	
	@ApiOperation(value = "Get by id")
	@GetMapping("/getById")
	public TransactionDto getByid(@Valid @RequestParam Long id) {
		return services.getById(id);
	}
	
	@ApiOperation(value = "Get all id")
	@GetMapping("/getAllId")
	public List<Long> getAllId() {
		return services.getAllId();
	}
	
}
