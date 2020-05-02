package com.enigmacamp.JasaQ.dto;

import javax.validation.constraints.NotEmpty;

public class ServicesMitraRequest {
	
	@NotEmpty(message = "services name may not be empty")
	private String servicesName;
	
	@NotEmpty(message = "logo may not be empty")
	private String logo;
	
	@NotEmpty(message = "Type tidak boleh kosong")
	private String type;
	
	public ServicesMitraRequest() {
		// TODO Auto-generated constructor stub
	}

	

	public ServicesMitraRequest(@NotEmpty(message = "services name may not be empty") String servicesName,
			@NotEmpty(message = "logo may not be empty") String logo,
			@NotEmpty(message = "Type tidak boleh kosong") String type) {
		super();
		this.servicesName = servicesName;
		this.logo = logo;
		this.type = type;
	}



	public String getServicesName() {
		return servicesName;
	}

	public void setServicesName(String servicesName) {
		this.servicesName = servicesName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
}
