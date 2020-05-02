package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;

public class MitraLogin {
	
	@NotEmpty(message = "username tidak boleh kosong")
	public String username;
	
	@NotEmpty(message = "password tidak boleh kosong")
	public String password;
	
	public MitraLogin() {
		// TODO Auto-generated constructor stub
	}

	public MitraLogin(@NotEmpty(message = "username tidak boleh kosong") String username,
			@NotEmpty(message = "password tidak boleh kosong") String password) {
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
