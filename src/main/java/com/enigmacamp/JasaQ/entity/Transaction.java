package com.enigmacamp.JasaQ.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date")
	private Date date;
	
	@DateTimeFormat
	@Column(name = "price")
	private Double price;
	
	@Column(name = "description", columnDefinition = "LONGTEXT")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "transactionClient")
	private Client transactionClient;
	
	@ManyToOne
	@JoinColumn(name = "transactionMitra")
	private Mitra transactionMitra;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long id, Date date, Double price, String description) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.description = description;
	}

	public Transaction(Date date, Double price, String description) {
		super();
		this.date = date;
		this.price = price;
		this.description = description;
	}

	public Transaction(Long id, Date date, Double price, String description, Client transactionClient,
			Mitra transactionMitra) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.description = description;
		this.transactionClient = transactionClient;
		this.transactionMitra = transactionMitra;
	}

	public Transaction(Date date, Double price, String description, Client transactionClient, Mitra transactionMitra) {
		super();
		this.date = date;
		this.price = price;
		this.description = description;
		this.transactionClient = transactionClient;
		this.transactionMitra = transactionMitra;
	}

	public Transaction(Date date, Double price, String description, Client transactionClient) {
		super();
		this.date = date;
		this.price = price;
		this.description = description;
		this.transactionClient = transactionClient;
	}

	public Transaction(Date date, Double price, String description, Mitra transactionMitra) {
		super();
		this.date = date;
		this.price = price;
		this.description = description;
		this.transactionMitra = transactionMitra;
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
	
	public Client getTransactionClient() {
		return transactionClient;
	}
	
	public void setTransactionClient(Client transactionClient) {
		this.transactionClient = transactionClient;
	}
	
	public Mitra getTransactionMitra() {
		return transactionMitra;
	}
	
	public void setTransactionMitra(Mitra transactionMitra) {
		this.transactionMitra = transactionMitra;
	}
}
