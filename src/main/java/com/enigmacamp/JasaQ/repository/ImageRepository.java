package com.enigmacamp.JasaQ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enigmacamp.JasaQ.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	Image findByName (String name);

}
