package com.enigmacamp.JasaQ.dto;

import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.enums.Status;

public class MitraDto {
	private Long id;
	
	private String name;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String photoProfile;
	
	private Status status;
	
	private String noHp;
	
	private String alamat;
	
	private Double saldo;
	
	private Role role;
	
	private ServiceMitraDto servicesMitra;
	
	private Double priceServices;
	
	public MitraDto() {
		// TODO Auto-generated constructor stub
	}

	public MitraDto(Long id, String name, String username, String password, String email, String photoProfile,
			Status status, String noHp, String alamat, Double saldo, Role role, ServiceMitraDto servicesMitra,
			Double priceServices) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.photoProfile = photoProfile;
		this.status = status;
		this.noHp = noHp;
		this.alamat = alamat;
		this.saldo = saldo;
		this.role = role;
		this.servicesMitra = servicesMitra;
		this.priceServices = priceServices;
	}

	public MitraDto(Long id, String name, String username, String password, String email, String photoProfile,
			Status status, String noHp, String alamat, Double saldo, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.photoProfile = photoProfile;
		this.status = status;
		this.noHp = noHp;
		this.alamat = alamat;
		this.saldo = saldo;
		this.role = role;
	}

	public MitraDto(String name, String username, String password, String email, String photoProfile,
			Status status, String noHp, String alamat, Double saldo, Role role, Double priceServices) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.photoProfile = photoProfile;
		this.status = status;
		this.noHp = noHp;
		this.alamat = alamat;
		this.saldo = saldo;
		this.role = role;
		this.priceServices = priceServices;
	}

	public MitraDto(String name, String username, String password, String email, String photoProfile, Status status,
			String noHp, String alamat, Double saldo, Role role, ServiceMitraDto servicesMitra, Double priceServices) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.photoProfile = photoProfile;
		this.status = status;
		this.noHp = noHp;
		this.alamat = alamat;
		this.saldo = saldo;
		this.role = role;
		this.servicesMitra = servicesMitra;
		this.priceServices = priceServices;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ServiceMitraDto getServicesMitra() {
		return servicesMitra;
	}

	public void setServicesMitra(ServiceMitraDto servicesMitra) {
		this.servicesMitra = servicesMitra;
	}

	public Double getPriceServices() {
		return priceServices;
	}

	public void setPriceServices(Double priceServices) {
		this.priceServices = priceServices;
	}

	
}
