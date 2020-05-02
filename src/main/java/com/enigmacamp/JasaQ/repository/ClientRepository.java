package com.enigmacamp.JasaQ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enigmacamp.JasaQ.entity.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findAll();
	
	Client findByUsernameContainsIgnoreCase(String name);
	
	Client findByUsername(String username);
	
	void deleteByUsername(String username);
}
