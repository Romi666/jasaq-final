package com.enigmacamp.JasaQ.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class TypeServices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany (mappedBy = "servicesMitra")
	private List<ServicesMitra> servicesMitra;
	
	public TypeServices() {
		// TODO Auto-generated constructor stub
	}

	public TypeServices(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public TypeServices(String type) {
		super();
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
