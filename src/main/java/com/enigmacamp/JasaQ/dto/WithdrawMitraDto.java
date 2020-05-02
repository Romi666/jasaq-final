package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class WithdrawMitraDto {
	
	@NotEmpty(message = "username may not empty")
	private String username;
	
	@NotEmpty(message = "no rekening may not empty")
	@Size(min = 5, message = "minimal mengandung 5 angka")
	private String noRekening;
	
	@NotNull(message = "ammount may not be null")
	private Double ammount;
	
	public WithdrawMitraDto() {
		// TODO Auto-generated constructor stub
	}

	public WithdrawMitraDto(@NotEmpty(message = "username may not empty") String username,
			@NotEmpty(message = "no rekening may not empty") @Size(min = 5, message = "minimal mengandung 5 angka") String noRekening,
			@NotNull(message = "ammount may not be null") Double ammount) {
		super();
		this.username = username;
		this.noRekening = noRekening;
		this.ammount = ammount;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNoRekening() {
		return noRekening;
	}

	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}

	public Double getAmmount() {
		return ammount;
	}

	public void setAmmount(Double ammount) {
		this.ammount = ammount;
	}
}
