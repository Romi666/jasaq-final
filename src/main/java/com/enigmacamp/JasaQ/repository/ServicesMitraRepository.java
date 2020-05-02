package com.enigmacamp.JasaQ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.ServicesMitra;

public interface ServicesMitraRepository extends JpaRepository<ServicesMitra, Long> {
	List<ServicesMitra> findAll();
	
	ServicesMitra findByServicesNameContainsIgnoreCase(String servicesName);
	
	void deleteById(Long id);
}
