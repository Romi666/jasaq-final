package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientUpdateProfile {
	@NotEmpty(message = "nama tidak boleh kosong")
	@Size(min = 3, message = "minimal 3 karakter")
	private String name;
	
	@NotEmpty(message = "username tidak boleh kosong")
	@Size(min = 5, message = "minimal 6 karakter")
	private String username;
	
	@NotEmpty(message = "password tidak boleh kosong")
	@Size(min = 5, message = "minimal 6 karakter")
	private String password;
	
	@NotEmpty(message = "No Hp tidak boleh kosong")
	@Size(min = 10, message = "minimal 11 karakter")
	private String noHp;
	
	@NotEmpty(message = "Email tidak boleh kosong")
	@Email
	private String email;
	
	private String alamat;
	
	public ClientUpdateProfile() {
		// TODO Auto-generated constructor stub
	}

	public ClientUpdateProfile(
			@NotEmpty(message = "nama tidak boleh kosong") @Size(min = 3, message = "minimal 3 karakter") String name,
			@NotEmpty(message = "username tidak boleh kosong") @Size(min = 5, message = "minimal 6 karakter") String username,
			@NotEmpty(message = "password tidak boleh kosong") @Size(min = 5, message = "minimal 6 karakter") String password,
			@NotEmpty(message = "No Hp tidak boleh kosong") @Size(min = 10, message = "minimal 11 karakter") String noHp,
			@NotEmpty(message = "Email tidak boleh kosong") @Email String email, String alamat) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.noHp = noHp;
		this.email = email;
		this.alamat = alamat;
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

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getAlamat() {
		return alamat;
	}
	
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
}
