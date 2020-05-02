package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MitraRequest {
	
	@NotEmpty(message = "nama tidak boleh kosong")
	@Size(min = 3, message = "minimal mengandung 4 karakter")
	private String name;
	
	@NotEmpty(message = "username tidak boleh kosong")
	@Size(min = 5, message = "minimal mengandung 6 karakter")
	private String username;
	
	@NotEmpty(message = "password tidak boleh kosong")
	@Size(min = 5, message = "minimal mengandung 6 karakter")
	private String password;
	
	@NotEmpty(message = "email tidak boleh kosong")
	@Email
	private String email;
	
	@NotEmpty(message = "Photo profile tidak boleh kosong")
	private String photoProfile;
	
	@NotEmpty(message = "No HP tidak boleh kosong")
	@Size(min = 10, message = "minimal mengandung 11 karakter")
	private String noHp;
	
	@NotEmpty(message = "alamat tidak boleh kosong")
	private String alamat;
	
	@NotEmpty(message = "service name tidak boleh kosong")
	private String servicesName;
	
	@NotNull(message = "price services tidak boleh kosong")
	@Min(10000)
	private Double priceServices;

	public MitraRequest() {
		// TODO Auto-generated constructor stub
	}

	public MitraRequest(
			@NotEmpty(message = "nama tidak boleh kosong") @Size(min = 3, message = "minimal mengandung 4 karakter") String name,
			@NotEmpty(message = "username tidak boleh kosong") @Size(min = 5, message = "minimal mengandung 6 karakter") String username,
			@NotEmpty(message = "password tidak boleh kosong") @Size(min = 5, message = "minimal mengandung 6 karakter") String password,
			@NotEmpty(message = "email tidak boleh kosong") @Email String email,
			@NotEmpty(message = "Photo profile tidak boleh kosong") String photoProfile,
			@NotEmpty(message = "No HP tidak boleh kosong") @Size(min = 10, message = "minimal mengandung 11 karakter") String noHp,
			@NotEmpty(message = "alamat tidak boleh kosong") String alamat,
			@NotEmpty(message = "service name tidak boleh kosong") String servicesName,
			@NotNull(message = "price services tidak boleh kosong") @Min(10000) Double priceServices) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.photoProfile = photoProfile;
		this.noHp = noHp;
		this.alamat = alamat;
		this.servicesName = servicesName;
		this.priceServices = priceServices;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoProfile() {
		return photoProfile;
	}

	public void setPhotoProfile(String photoProfile) {
		this.photoProfile = photoProfile;
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
	
	 public Double getPriceServices() {
		return priceServices;
	}
	 
	 public void setPriceServices(Double priceServices) {
		this.priceServices = priceServices;
	}
	 
	 public String getServicesName() {
		return servicesName;
	}
	 
	 public void setServicesName(String servicesName) {
		this.servicesName = servicesName;
	}
}
