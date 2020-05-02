package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;

public class TypeServicesRequest {
	@NotEmpty(message = "Masukan type services")
	public String type;
	

	public TypeServicesRequest(String type) {
		super();
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
