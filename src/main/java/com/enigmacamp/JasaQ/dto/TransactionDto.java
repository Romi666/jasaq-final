package com.enigmacamp.JasaQ.dto;

import java.sql.Date;

public class TransactionDto {

	private Long id;
	
	private Date date;
	
	private Double price;
	
	private String description;
	
	public TransactionDto() {
		// TODO Auto-generated constructor stub
	}

	public TransactionDto(Long id, Date date, Double price, String description) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.description = description;
	}

	public TransactionDto(Date date, Double price, String description) {
		super();
		this.date = date;
		this.price = price;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
