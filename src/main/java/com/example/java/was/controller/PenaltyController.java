package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.service.PenaltyService;

@RestController
@ResponseBody
@RequestMapping("/api/*")
public class PenaltyController {
	private static Logger logger = LoggerFactory.getLogger(PenaltyController.class);
	
	@Autowired PenaltyService penaltyService;
	
	/**
	 * 2000 : 패널티 등록
	 */
	@PostMapping("/penalty/regist/{vocId}")
	public HashMap<String, Object> regist(@PathVariable("vocId") Long vocId) {
		
		logger.info("penalty regist : " + vocId);
		
		return penaltyService.setPenalty(vocId);
	}
	
	/**
	 * 2001 : 패널티 확인 여부
	 */
	@PutMapping("/penalty/state/{vocId}")
	public HashMap<String, Object> registration(@PathVariable("vocId") Long vocId,
			@RequestParam(value="stateCode",required=false, defaultValue="none") String stateCode) {
		
		logger.info("state set : " + vocId);
		
		return penaltyService.setState(vocId,stateCode);
	}
}
