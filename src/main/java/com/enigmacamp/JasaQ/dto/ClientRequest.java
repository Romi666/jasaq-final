package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientRequest {
	
	@NotEmpty(message = "Nama tidak boleh kosong")
	@Size(min = 3, message = "minimal mengandung 4 karakter")
	private String name;
	
	@NotEmpty(message = "username tidak boleh kosong")
	@Size(min = 5, message = "Minimal mengandung 6 karakter")
	private String username;
	
	@NotEmpty(message = "password tidak boleh kosong")
	@Size(min = 5, message = "Minimal mengandung 6 karakter")
	private String password;
	
	@NotEmpty(message = "Url tidak boleh kosong")
	private String photoProfile;
	
	@NotEmpty(message = "Email tidak boleh kosong")
	@Email
	private String email;
	
	@NotEmpty(message = "No hp tidak boleh kosong")
	@Size(min = 10, message = "Minimal mengandung 11 angka")
	private String noHp;
	
	@NotEmpty(message = "Alamat tidak boleh kosong")
	private String alamat;
	
	public ClientRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public ClientRequest(
			@NotEmpty(message = "Nama tidak boleh kosong") @Size(min = 3, message = "minimal mengandung 4 karakter") String name,
			@NotEmpty(message = "username tidak boleh kosong") @Size(min = 5, message = "Minimal mengandung 6 karakter") String username,
			@NotEmpty(message = "password tidak boleh kosong") @Size(min = 5, message = "Minimal mengandung 6 karakter") String password,
			@NotEmpty(message = "Url tidak boleh kosong") String photoProfile,
			@NotEmpty(message = "Email tidak boleh kosong") String email,
			@NotEmpty(message = "No hp tidak boleh kosong") @Size(min = 10, message = "Minimal mengandung 11 angka") String noHp,
			@NotEmpty(message = "Alamat tidak boleh kosong") String alamat) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.photoProfile = photoProfile;
		this.email = email;
		this.noHp = noHp;
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
}
