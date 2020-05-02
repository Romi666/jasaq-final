package com.enigmacamp.JasaQ.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requestForm")
public class RequestForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "bookingDate")
	private String bookingDate;
	
	@Column(name = "description", columnDefinition = "LONGTEXT")
	private String description;
	
	@Column(name = "statusPembayaran")
	private String statusPembayaran;
	
	@ManyToOne
	@JoinColumn(name = "receiver")
	private Mitra receiver;
	
	@ManyToOne
	@JoinColumn(name = "sender")
	private Client sender;
	
	public RequestForm() {
		// TODO Auto-generated constructor stub
	}

	public RequestForm(Long id, String bookingDate, String description, Mitra receiver, Client sender, String statusPembayaran) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.description = description;
		this.receiver = receiver;
		this.sender = sender;
		this.statusPembayaran = statusPembayaran;
	}

	public RequestForm(String bookingDate, String description, Mitra receiver, Client sender, String statusPembayaran) {
		super();
		this.bookingDate = bookingDate;
		this.description = description;
		this.receiver = receiver;
		this.sender = sender;
		this.statusPembayaran = statusPembayaran;
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

	public Mitra getReceiver() {
		return receiver;
	}

	public void setReceiver(Mitra receiver) {
		this.receiver = receiver;
	}

	public Client getSender() {
		return sender;
	}

	public void setSender(Client sender) {
		this.sender = sender;
	}
	
	public String getStatusPembayaran() {
		return statusPembayaran;
	}
	
	public void setStatusPembayaran(String statusPembayaran) {
		this.statusPembayaran = statusPembayaran;
	}
	
	
}
