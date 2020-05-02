package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class MitraSetServicesType {
	private String username;
	
	private String servicesMitra;
	
	private Double priceServices;
	
	public MitraSetServicesType() {
		// TODO Auto-generated constructor stub
}

	
	public MitraSetServicesType(String username, String servicesMitra, Double priceServices) {
		super();
		this.username = username;
		this.servicesMitra = servicesMitra;
		this.priceServices = priceServices;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getServicesMitra() {
		return servicesMitra;
	}

	public void setServicesMitra(String servicesMitra) {
		this.servicesMitra = servicesMitra;
	}

	public Double getPriceServices() {
		return priceServices;
	}

	public void setPriceServices(Double priceServices) {
		this.priceServices = priceServices;
	}
	

}
