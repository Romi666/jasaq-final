package com.enigmacamp.JasaQ.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.enigmacamp.JasaQ.enums.Role;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nama")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "photoProfile", columnDefinition = "LONGTEXT")
	private String photoProfile;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "noHp")
	private String noHp;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "saldo")
	private Double saldo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	@OneToMany(mappedBy = "transactionClient")
	List<Transaction> transactionClient;
	
	@OneToMany(mappedBy = "sender")
	List<RequestForm> sender;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	

	public Client(Long id, String name, String username, String password, String photoProfile, String email, String noHp,
			String alamat, Double saldo) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.photoProfile = photoProfile;
		this.email = email;
		this.noHp = noHp;
		this.alamat = alamat;
		this.saldo = saldo;
	}

	
	public Client(String name, String username, String password, String photoProfile, String email, String noHp,
			String alamat, Double saldo) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.photoProfile = photoProfile;
		this.email = email;
		this.noHp = noHp;
		this.alamat = alamat;
		this.saldo = saldo;
	}


	public Client(String name, String username, String password, String photoProfile, String email, String noHp,
			String alamat, Double saldo, Role role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.photoProfile = photoProfile;
		this.email = email;
		this.noHp = noHp;
		this.alamat = alamat;
		this.saldo = saldo;
		this.role = role;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoProfile() {
		return photoProfile;
	}

	public void setPhotoProfile(String photoProfile) {
		this.photoProfile = photoProfile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
