package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountAddBalance {
	
	@NotEmpty(message = "name may not empty")
	private String username;
	
	@NotNull(message = "Ammount mau not null")
	private Double ammount;
	
	public AccountAddBalance() {
		// TODO Auto-generated constructor stub
	}

	public AccountAddBalance(@NotEmpty(message = "name may not empty") String username,
			@NotNull(message = "Ammount mau not null") Double ammount) {
		super();
		this.username = username;
		this.ammount = ammount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}

	
}
