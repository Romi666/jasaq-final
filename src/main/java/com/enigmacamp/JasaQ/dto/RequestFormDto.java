package com.enigmacamp.JasaQ.dto;

public class RequestFormDto {
	private Long id;
	
	private String bookingDate;
	
	private String description;
	
	private MitraDto receiver;
	
	private ClientDto sender;
	
	private String statusPembayaran;
	
	public RequestFormDto() {
		// TODO Auto-generated constructor stub
	}

	public RequestFormDto(Long id, String bookingDate, String description, MitraDto receiver, ClientDto sender, String statusPembayaran) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.description = description;
		this.receiver = receiver;
		this.sender = sender;
		this.statusPembayaran = statusPembayaran;
	}

	public RequestFormDto(String bookingDate, String description, MitraDto receiver, ClientDto sender) {
		super();
		this.bookingDate = bookingDate;
		this.description = description;
		this.receiver = receiver;
		this.sender = sender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public MitraDto getReceiver() {
		return receiver;
	}

	public void setReceiver(MitraDto receiver) {
		this.receiver = receiver;
	}

	public ClientDto getSender() {
		return sender;
	}

	public void setSender(ClientDto sender) {
		this.sender = sender;
	}
	
	public void setStatusPembayaran(String statusPembayaran) {
		this.statusPembayaran = statusPembayaran;
	}
	
	public String getStatusPembayaran() {
		return statusPembayaran;
	}
	
}
