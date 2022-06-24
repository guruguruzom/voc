package com.example.java.was.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.dto.CompensationDto;
import com.example.java.was.service.CompensationService;

@RestController
public class CompensationController {
	private static Logger logger = LoggerFactory.getLogger(CompensationController.class);
	
	@Autowired CompensationService compensationService;
	
	/**
	 * 3000 : 배상 정보 등록
	 */
	@PostMapping("/compensation/regist")
    public void registration(@RequestBody CompensationDto compensationDto) {
		
		logger.info("compensation registration : " + compensationDto.toString());
		
		compensationService.setCompensation(compensationDto);
    }
	
}
