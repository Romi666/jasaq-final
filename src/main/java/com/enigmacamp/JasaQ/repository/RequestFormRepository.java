package com.enigmacamp.JasaQ.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enigmacamp.JasaQ.entity.RequestForm;

public interface RequestFormRepository extends JpaRepository<RequestForm, Long> {
	void deleteById(Long id);
	
	Optional<RequestForm> findById(Long id);
	
	List<RequestForm> findAll();
}
