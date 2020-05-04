package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;

public class ClientLoginDto {
	
	@NotEmpty(message = "Username tidak boleh kosong")
	private String username;
	
	@NotEmpty(message = "Password tidak boleh kosong")
	private String password;
	
	public ClientLoginDto() {
		// TODO Auto-generated constructor stub
	}

	public ClientLoginDto(@NotEmpty(message = "Username tidak boleh kosong") String username,
			@NotEmpty(message = "Password tidak boleh kosong") String password) {
		super();
		this.username = username;
		this.password = password;
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
}
