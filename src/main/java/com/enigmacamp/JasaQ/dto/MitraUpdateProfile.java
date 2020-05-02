package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MitraUpdateProfile {
	@NotEmpty(message = "nama tidak boleh kosong")
	@Size(min = 3, message = "minimal 4 karakter")
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
	
	@NotNull
	@Min(10000)
	private Double priceServices;
	
	@NotEmpty
	@Email
	private String email;
	
	public MitraUpdateProfile(
			@NotEmpty(message = "nama tidak boleh kosong") @Size(min = 3, message = "minimal 4 karakter") String name,
			@NotEmpty(message = "username tidak boleh kosong") @Size(min = 5, message = "minimal 6 karakter") String username,
			@NotEmpty(message = "password tidak boleh kosong") @Size(min = 5, message = "minimal 6 karakter") String password,
			@NotEmpty(message = "No Hp tidak boleh kosong") @Size(min = 10, message = "minimal 11 karakter") String noHp,
			@NotNull @Min(10000) Double priceServices, @NotEmpty @Email String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.noHp = noHp;
		this.priceServices = priceServices;
		this.email = email;
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

	public Double getPriceServices() {
		return priceServices;
	}

	public void setPriceServices(Double priceServices) {
		this.priceServices = priceServices;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
