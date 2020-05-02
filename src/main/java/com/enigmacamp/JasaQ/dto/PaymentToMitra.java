package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;

public class PaymentToMitra {
	@NotEmpty(message = "may not empty")
	private String usernameClient;
	
	@NotEmpty(message = "may not empty")
	private String usernameMitra;
	
	public PaymentToMitra() {
		// TODO Auto-generated constructor stub
	}

	public PaymentToMitra(@NotEmpty(message = "may not empty") String usernameClient,
			@NotEmpty(message = "may not empty") String usernameMitra) {
		super();
		this.usernameClient = usernameClient;
		this.usernameMitra = usernameMitra;
	}

	public String getUsernameClient() {
		return usernameClient;
	}

	public void setUsernameClient(String usernameClient) {
		this.usernameClient = usernameClient;
	}

	public String getUsernameMitra() {
		return usernameMitra;
	}

	public void setUsernameMitra(String usernameMitra) {
		this.usernameMitra = usernameMitra;
	}
	
	
}
