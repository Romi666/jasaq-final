package com.enigmacamp.JasaQ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.ServicesMitra;

public interface MitraRepository extends JpaRepository<Mitra, Long> {
	List<Mitra> findAll();
	
	Mitra findByNameContainsIgnoreCase(String name);
	
	Mitra findByUsername(String username);
	
	void deleteById (Long id);
	
	List<Mitra> findByServicesMitra(ServicesMitra servicesMitra);
	
	Mitra findByUsernameAndPassword(String username, String password);
}
