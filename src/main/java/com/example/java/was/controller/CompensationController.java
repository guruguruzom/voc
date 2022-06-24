package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.dto.CompensationDto;
import com.example.java.was.service.CompensationService;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.SuccessState;

@RestController
@ResponseBody
@RequestMapping("/api/*")
public class CompensationController {
	private static Logger logger = LoggerFactory.getLogger(CompensationController.class);
	
	@Autowired CompensationService compensationService;
	
	/**
	 * 3000 : 배상 정보 등록
	 */
	@PostMapping("/compensation/regist")
    public HashMap<String, Object> registration(@RequestBody CompensationDto compensationDto) {
		
		logger.info("compensation registration : " + compensationDto.toString());
		
		SuccessState successState = compensationService.setCompensation(compensationDto);
		
		return ResponseMap.getResponseMap(successState);
    }
	
}
