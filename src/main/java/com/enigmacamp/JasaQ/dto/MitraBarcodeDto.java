package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MitraBarcodeDto {
	
	@NotEmpty(message = "May not empty")
	private String username;
	
	@NotNull(message = "May not null")
	private Double priceServices;
	

	public MitraBarcodeDto(@NotEmpty(message = "May not empty") String username,
			@NotNull(message = "May not null") Double priceServices) {
		super();
		this.username = username;
		this.priceServices = priceServices;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getPriceServices() {
		return priceServices;
	}

	public void setPriceServices(Double priceServices) {
		this.priceServices = priceServices;
	}
	
	
	
	
}
