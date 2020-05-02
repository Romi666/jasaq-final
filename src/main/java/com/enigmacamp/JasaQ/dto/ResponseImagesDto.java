package com.enigmacamp.JasaQ.dto;

public class ResponseImagesDto {
	private String name;
	private String type;
	private long picByte;
	
	public ResponseImagesDto() {
		// TODO Auto-generated constructor stub
	}

	public ResponseImagesDto(String name, String type, long picByte) {
		super();
		this.name = name;
		this.type = type;
		this.picByte = picByte;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPicByte() {
		return picByte;
	}

	public void setPicByte(long picByte) {
		this.picByte = picByte;
	}
	
	
}
