package com.enigmacamp.JasaQ.dto;


public class ServiceMitraDto {
	private Long id;
	
	private String servicesName;
	
	private String logo;
	
	private TypeServicesDto servicesMitra;
	
	public ServiceMitraDto() {
		// TODO Auto-generated constructor stub
	}

	public ServiceMitraDto(Long id, String servicesName, String logo, TypeServicesDto servicesMitra) {
		super();
		this.id = id;
		this.servicesName = servicesName;
		this.logo = logo;
		this.servicesMitra = servicesMitra;
	}

	public ServiceMitraDto(String servicesName, String logo, TypeServicesDto servicesMitra) {
		super();
		this.servicesName = servicesName;
		this.logo = logo;
		this.servicesMitra = servicesMitra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TypeServicesDto getServicesMitra() {
		return servicesMitra;
	}

	public void setServicesMitra(TypeServicesDto servicesMitra) {
		this.servicesMitra = servicesMitra;
	}
	
}
