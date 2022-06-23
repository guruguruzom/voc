package com.example.java.was.controller;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.dto.VocDto;
import com.example.java.was.service.impl.VocServiceImpl;

@RestController
public class VocController {

	private static Logger logger = LoggerFactory.getLogger(VocController.class);
	
	@Autowired VocServiceImpl vocServiceImpl;
	
	/**
	 * 1001 : voc µî·Ï
	 */
	@PostMapping("/api/registration")
    public void registration(@RequestBody VocDto vocDto) {
		
		logger.info("service class Hello : " + vocDto.toString());
		
		System.out.println(vocDto.toString());
		System.out.println(vocDto.getReason());
		vocServiceImpl.setVoc(vocDto);
    }
	
}

