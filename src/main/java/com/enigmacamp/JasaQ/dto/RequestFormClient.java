package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;

public class RequestFormClient {
	@NotEmpty (message = "booking date may not empty")
	private String bookingDate;
	
	@NotEmpty(message = "description may not empty")
	private String description;
	
	@NotEmpty(message = "receiver may not empty")
	private String receiver;
	
	@NotEmpty(message = "sender may not empty")
	private String sender;
	
	public RequestFormClient(@NotEmpty(message = "booking date may not empty") String bookingDate,
			@NotEmpty(message = "description may not empty") String description,
			@NotEmpty(message = "receiver may not empty") String receiver,
			@NotEmpty(message = "sender may not empty") String sender) {
		super();
		this.bookingDate = bookingDate;
		this.description = description;
		this.receiver = receiver;
		this.sender = sender;
	}



	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReceiver() {
		return receiver;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
}
