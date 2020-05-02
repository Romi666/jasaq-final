package com.enigmacamp.JasaQ.dto;

import com.enigmacamp.JasaQ.enums.Role;

public class ClientDto {
	
	private Long id;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String photoProfile;
	
	private String email;
	
	private String noHp;
	
	private String alamat;
	
	private Double saldo;
	
	private Role role;
	
	public ClientDto() {
		// TODO Auto-generated constructor stub
	}

	public ClientDto(Long id, String name, String username, String password, String photoProfile, String email,
			String noHp, String alamat, Double saldo) {
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

	public ClientDto(String name, String username, String password, String photoProfile, String email, String noHp,
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

	public ClientDto(String name, String username, String password, String photoProfile, String email, String noHp,
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
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
}
