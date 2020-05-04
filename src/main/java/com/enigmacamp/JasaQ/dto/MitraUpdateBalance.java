package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MitraUpdateBalance {
	@NotEmpty(message = "Username may not empty")
	private String username;
	
	@NotNull(message = "Balance may not null")
	private Double ammount;
	
	public MitraUpdateBalance() {
		// TODO Auto-generated constructor stub
	}
	
	public MitraUpdateBalance(@NotEmpty(message = "Username may not empty") String username,
			@NotNull(message = "Balance may not null") Double ammount) {
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
