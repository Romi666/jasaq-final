package com.enigmacamp.JasaQ.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enigmacamp.JasaQ.dto.MitraDto;
import com.enigmacamp.JasaQ.dto.MitraRequest;
import com.enigmacamp.JasaQ.dto.MitraSetServicesType;
import com.enigmacamp.JasaQ.dto.MitraUpdateProfile;
import com.enigmacamp.JasaQ.dto.ServiceMitraDto;
import com.enigmacamp.JasaQ.entity.Mitra;
import com.enigmacamp.JasaQ.entity.ServicesMitra;
import com.enigmacamp.JasaQ.enums.Role;
import com.enigmacamp.JasaQ.enums.Status;
import com.enigmacamp.JasaQ.exceptions.NotFoundException;
import com.enigmacamp.JasaQ.repository.MitraRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import net.glxn.qrgen.javase.QRCode;

@Service
public class MitraServices {
	
	@Autowired
	MitraRepository repo;
	
	@Autowired
	MitraServicesServices mitraServ;
	
	public MitraDto convertDto(Mitra mitra) {
		ModelMapper modelMapper = new ModelMapper();
		MitraDto dto = modelMapper.map(mitra, MitraDto.class);
		return dto;
	}
	
	public Mitra convertMitra(MitraDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Mitra mitra = modelMapper.map(dto, Mitra.class);
		return mitra;
	}
	
	public MitraDto getById(Long id) {
		Mitra mitra = repo.findById(id).get();
		return convertDto(mitra);
	}
	
	public MitraDto create(@Valid MitraRequest request) {
	Mitra check = repo.findByUsername(request.getUsername());
	ServiceMitraDto servMitraDto = mitraServ.getByName(request.getServicesName());
	if(check!=null) {
		throw new NotFoundException("username sudah ada");
	}
	if(servMitraDto==null) {
		throw new NotFoundException("Service tidak ada");
	}
	ServicesMitra servMitra= mitraServ.convertEntity(servMitraDto);
	Mitra mitra = new Mitra(request.getName(), request.getUsername(), request.getPassword(), request.getEmail(),
			request.getPhotoProfile(), Status.AVAILABLE, 
			request.getNoHp(), request.getAlamat(), 0.0, Role.MITRA, servMitra, request.getPriceServices());
	repo.save(mitra);
	return convertDto(mitra);
	}
	
	public void SetServicesMitraReq( MitraSetServicesType request) {
		Mitra mitra = repo.findByUsername(request.getUsername());
		ServiceMitraDto dtoServMitra = mitraServ.getByName(request.getServicesMitra());
		System.out.println("Dari mitra entity "+ mitra.getName());
		mitra.setPriceServices(request.getPriceServices());
		mitra.setServicesMitra(mitraServ.convertEntity(dtoServMitra));
		repo.save(mitra);
	}
	
	public void updateBalance(@Valid String mitraUsername, Double ammount) {
		MitraDto dto = getByUsername(mitraUsername);
		Mitra mitra = convertMitra(dto);
		mitra.setSaldo(mitra.getSaldo() + ammount);
		repo.save(mitra);
	}
	
	public List<Mitra> getAll() {
		return repo.findAll();
	}
	
	public MitraDto getMitraByUsernameAndPassword(@Valid String username, String password) {
		Mitra mitra1 = repo.findByUsernameAndPassword(username, password);
		return convertDto(mitra1);
	}
	
	public List<Mitra> getByServicesMitra(@Valid String servicesType) {
		ServiceMitraDto servMitraDto = mitraServ.getByName(servicesType);
		ServicesMitra servMitra = mitraServ.convertEntity(servMitraDto);
		List<Mitra> newMitra = repo.findByServicesMitra(servMitra);
		return newMitra;
	}
	
	public MitraDto getByUsername(@Valid String username) {
		Mitra mitra = repo.findByUsername(username);
		return convertDto(mitra);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	public MitraDto updateMitra(@Valid MitraUpdateProfile request) {
		Mitra mitra = repo.findByUsername(request.getUsername());
		mitra.setName(request.getName());
		mitra.setEmail(request.getEmail());
		mitra.setPriceServices(request.getPriceServices());
		mitra.setPassword(request.getPassword());
		mitra.setNoHp(request.getNoHp());
		repo.save(mitra);
		
		return convertDto(mitra); 
	}
	
	
	public void updateAdd(@Valid String username, Double ammount) {
		Mitra mitra = repo.findByUsername(username);
		mitra.setSaldo(mitra.getSaldo()+ammount);
		repo.save(mitra);
	}
	
	public void updateSubstract(@Valid String username, Double ammount) {
		Mitra mitra = repo.findByUsername(username);
		mitra.setSaldo(mitra.getSaldo()-ammount);
		repo.save(mitra);
	}
	
	public static BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
	    ByteArrayOutputStream stream = QRCode
	      .from(barcodeText)
	      .withSize(250, 250)
	      .stream();
	    ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
	 
	    return ImageIO.read(bis);
	}
	
	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
	    QRCodeWriter QRWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = QRWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 500, 500);
	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
}
