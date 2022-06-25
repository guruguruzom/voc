package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.domain.CompensationDto;
import com.example.java.was.service.CompensationService;

@RestController
@ResponseBody
@RequestMapping("/api/*")
public class CompensationController {
	private static Logger logger = LoggerFactory.getLogger(CompensationController.class);
	
	@Autowired CompensationService compensationService;
	
	/***
	 * 3000 : 배상 정보 등록
	 * @param compensationDto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/compensation/regist")
    public HashMap<String, Object> regist(@RequestBody CompensationDto compensationDto) throws Exception {
		
		logger.info("compensation regist : " + compensationDto.toString());
	
		return compensationService.setCompensation(compensationDto);
    }
	
	@GetMapping("/compensation/list")
	public HashMap<String, Object> registration() throws Exception {
		
		logger.info("compensation list : ");
	
		return compensationService.getCompensationList();
    }
	
}
