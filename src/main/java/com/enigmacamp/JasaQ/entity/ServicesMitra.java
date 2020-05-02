package com.enigmacamp.JasaQ.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "servicesMitra")
public class ServicesMitra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "servicesName")
	private String servicesName;
	
	@OneToMany (mappedBy = "servicesMitra")
	private List<Mitra> mitra;
	
	@Column(name = "logo", columnDefinition = "LONGTEXT")
	private String logo;
	
	@ManyToOne
	@JoinColumn(name = "servicesMitra")
	private TypeServices servicesMitra;
	
	public ServicesMitra() {
		// TODO Auto-generated constructor stub
	}


	public ServicesMitra(Long id, String servicesName, String logo) {
		super();
		this.id = id;
		this.servicesName = servicesName;
		this.logo = logo;
	}
	

	public ServicesMitra(String servicesName, String logo, TypeServices servicesMitra) {
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



	public TypeServices getServicesMitra() {
		return servicesMitra;
	}



	public void setServicesMitra(TypeServices servicesMitra) {
		this.servicesMitra = servicesMitra;
	}


	
}
