package com.enigmacamp.JasaQ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enigmacamp.JasaQ.entity.Image;
import com.enigmacamp.JasaQ.exceptions.FileStorageException;
import com.enigmacamp.JasaQ.exceptions.MyFileNotFoundException;
import com.enigmacamp.JasaQ.services.ImagesServices;

import io.swagger.annotations.Api;


@Api (value = "JasaQ")
@RestController
@EnableAutoConfiguration
@RequestMapping("/images")
@Validated
@CrossOrigin(origins = "*")
public class ImageUploadController {
	
	@Autowired
	private ImagesServices services;
	
	@PostMapping("/upload/serviceMitra/{id}") 
	public Image uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws FileStorageException {
		String filename = services.storeFile(file);
		
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile").path(filename).toUriString();
		services.save(new Image(null, filename, file.getContentType(), file.getSize()),id);
		return new Image(1L, filename, file.getContentType(), file.getSize());
	}
	
	@PostMapping("/upload/mitra/{id}")
	public Image uploadImageMitra(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws FileStorageException {
		String filename = services.storeFile(file);
		
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile").path(filename).toUriString();
		services.saveForPhotoMitra(new Image(null, filename, file.getContentType(), file.getSize()), id);
		return new Image(1L, filename, file.getContentType(), file.getSize());
	}
	
	@PostMapping("/upload/client/{id}")
	public Image uploadImageClient(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws FileStorageException {
		String filename = services.storeFile(file);
		
		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile").path(filename).toUriString();
		services.saveForPhotoClient(new Image(null, filename, file.getContentType(), file.getSize()), id);
		return new Image(1L, filename, file.getContentType(), file.getSize());
	}
	
	@GetMapping(value = "getImage/{name}",produces = MediaType.IMAGE_PNG_VALUE)
	public Resource loadAsReasource(@RequestParam String name) throws MyFileNotFoundException {
		return services.loadFileAsResource(name);
	}
}
