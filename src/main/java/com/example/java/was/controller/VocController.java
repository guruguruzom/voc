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
import com.example.java.was.service.VocService;

@RestController
public class VocController {

	private static Logger logger = LoggerFactory.getLogger(VocController.class);
	
	@Autowired VocService vocService;
	
	/**
	 * 1000 : voc µî·Ï
	 */
	@PostMapping("/voc/regist")
    public void registration(@RequestBody VocDto vocDto) {
		
		logger.info("voc registration : " + vocDto.toString());
		
		System.out.println(vocDto.toString());
		System.out.println(vocDto.getReason());
		vocService.setVoc(vocDto);
    }
	
}

