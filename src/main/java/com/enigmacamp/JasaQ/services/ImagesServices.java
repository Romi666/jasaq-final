package com.enigmacamp.JasaQ.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.enigmacamp.JasaQ.entity.Client;
import com.enigmacamp.JasaQ.entity.Image;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.exceptions.FileStorageException;
import com.enigmacamp.JasaQ.exceptions.FileStorageProperties;
import com.enigmacamp.JasaQ.exceptions.MyFileNotFoundException;
import com.enigmacamp.JasaQ.repository.ClientRepository;
import com.enigmacamp.JasaQ.repository.ImageRepository;
import com.enigmacamp.JasaQ.repository.MitraRepository;
import com.enigmacamp.JasaQ.repository.ServicesMitraRepository;

@Service
public class ImagesServices {
	
	private final Path fileStorageLocation;
	
	@Autowired
	ImageRepository repo;
	
	@Autowired
	ServicesMitraRepository servMitraRepo;
	
	@Autowired
	MitraRepository mitraRepo;
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	public ImagesServices(FileStorageProperties fileStorageProperties) throws FileStorageException {
		this.fileStorageLocation = Paths.get(((FileStorageProperties)fileStorageProperties).getUploadDir()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Could not create directory where the uploaded will be restored.", e);
			// TODO: handle exception
		}
	}
	
	public String storeFile(MultipartFile file) throws FileStorageException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(filename.contains("..")) {
				throw new FileStorageException("Sorry! filename contains invalid characters " + filename);
			}
			
			Path targetLocation = this.fileStorageLocation.resolve(filename);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return filename;
		} catch (IOException e) {
			// TODO: handle exception
			throw new FileStorageException("Could not store file " + filename, e);
		}
	}
	
	public Resource loadFileAsResource(String filename) throws MyFileNotFoundException {
		try {
			Path filePath = this.fileStorageLocation.resolve(filename).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			}else {
				throw new MyFileNotFoundException("File not found" + filename);
			}
		} catch (MalformedURLException e) {
			throw new MyFileNotFoundException("File not found " + filename, e);
			// TODO: handle exception
		}
	}
	
	public Image save(Image image, Long id) {
		ServicesMitra servMitar = servMitraRepo.findById(id).get();
		String filename = "http://10.10.12.30:7000/images/getImage/%7Bname%7D?name="+image.getName().toString();
		servMitar.setLogo(filename);
		servMitraRepo.save(servMitar);
		return image;
	}
	
	
	public Image saveForPhotoMitra(Image image, Long id) {
		Mitra mitra = mitraRepo.findById(id).get();
		String filename = "http://10.10.12.30:7000/images/getImage/%7Bname%7D?name="+image.getName().toString();
		mitra.setPhotoProfile(filename);
		mitraRepo.save(mitra);
		return image;
	}
	
	public Image saveForPhotoClient(Image image, Long id) {
		Client client = clientRepo.findById(id).get();
		String filename = "http://10.10.12.30:7000/images/getImage/%7Bname%7D?name="+image.getName().toString();
		client.setPhotoProfile(filename);
		clientRepo.save(client);
		return image;
	}
}
