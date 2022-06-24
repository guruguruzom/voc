package com.example.java.was.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.dto.PenaltyDto;
import com.example.java.was.service.PenaltyService;

@RestController
public class PenaltyController {
	private static Logger logger = LoggerFactory.getLogger(PenaltyController.class);
	
	@Autowired PenaltyService penaltyService;
	
	/**
	 * 2000 : 패널티 등록
	 */
	@PostMapping("/penalty/regist")
	public void registration(@RequestBody PenaltyDto penaltyDto) {
		
		logger.info("penalty regist : " + penaltyDto.toString());
		
		penaltyService.setPenalty(penaltyDto);
	}
}
