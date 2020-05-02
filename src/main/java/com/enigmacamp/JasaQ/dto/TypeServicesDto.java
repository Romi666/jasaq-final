package com.enigmacamp.JasaQ.dto;

public class TypeServicesDto {
	private Long id;
	
	private String type;
	
	public TypeServicesDto() {
		// TODO Auto-generated constructor stub
	}

	public TypeServicesDto(String type) {
		super();
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
