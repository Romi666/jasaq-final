package com.enigmacamp.JasaQ.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigmacamp.JasaQ.entity.PushNotificationRequest;
import com.enigmacamp.JasaQ.entity.PushNotificationResponse;
import com.enigmacamp.JasaQ.services.PushNotificationService;

import io.swagger.annotations.Api;
@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("PushNotification")
@Validated
@CrossOrigin(origins = "*")
public class PushNotificationController {
	
	private PushNotificationService service;
	
	public PushNotificationController(PushNotificationService service) {
		this.service = service;
	}
	
	@PostMapping("/topic")
	public ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) {
		service.sendPushNotificationWithoutData(request);
		return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	}
	
	@PostMapping("/token")
	public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
		service.sendPushNotificationToToken(request);
		return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	}
	
	@PostMapping("/data")
	public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
		service.sendPushNotification(request);
		return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	}
	
	@GetMapping("/notifications")
	public ResponseEntity sendSampleNotification() {
		service.sendSamplePushNotification();
		return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
	}
}