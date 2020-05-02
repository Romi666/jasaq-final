package com.enigmacamp.JasaQ.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.enums.Status;

@Entity
@Table(name = "mitra")
public class Mitra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nama")
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "photoProfile", columnDefinition = "LONGTEXT")
	private String photoProfile;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;
	
	@Column(name = "noHp")
	private String noHp;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "saldo")
	private Double saldo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	@ManyToOne
	@JoinColumn (name = "servicesMitra")
	private ServicesMitra servicesMitra;
	
	@Column(name = "priceServices")
	private Double priceServices;
	
	@OneToMany(mappedBy = "transactionMitra")
	private List<Transaction> transactionMitra;
	
	@OneToMany(mappedBy = "receiver")
	private List<RequestForm> receiver;
	
	public Mitra() {
		// TODO Auto-generated constructor stub
	}

	public Mitra(Long id, String name, String username, String password, String email, String photoProfile,
			Status status, String noHp, String alamat, Double saldo, Role role, ServicesMitra servicesMitra,
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

	public Mitra(String name, String username, String password, String email, String photoProfile, Status status,
			String noHp, String alamat, Double saldo, Role role, ServicesMitra servicesMitra, Double priceServices) {
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

	public Mitra(String name, String username, String password, String email, String photoProfile, Status status,
			String noHp, String alamat, Double saldo, Role role, Double priceServices) {
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

	public ServicesMitra getServicesMitra() {
		return servicesMitra;
	}

	public void setServicesMitra(ServicesMitra servicesMitra) {
		this.servicesMitra = servicesMitra;
	}
	
	public void setPriceServices(Double priceServices) {
		this.priceServices = priceServices;
	}
	
	public Double getPriceServices() {
		return priceServices;
	}
}
