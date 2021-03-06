package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.domain.CompensationDto;
import com.example.java.was.service.impl.CompensationServiceImpl;

@RestController
@ResponseBody
@RequestMapping("/api/*")
public class CompensationController {
	private static Logger logger = LoggerFactory.getLogger(CompensationController.class);
	
	@Autowired CompensationServiceImpl compensationService;
	
	/***
	 * 3000 : 배상정보 등록
	 * @param compensationDto
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/compensation/regist/{vocId}")
    public HashMap<String, Object> regist(@RequestBody CompensationDto compensationDto,@PathVariable("vocId") Long vocId) throws Exception {
		
		logger.info("compensation regist : " + vocId);
	
		return compensationService.setCompensation(vocId,compensationDto);
    }
	
}
