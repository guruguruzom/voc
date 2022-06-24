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

import com.example.java.was.dto.VocDto;
import com.example.java.was.service.VocService;
import com.example.java.was.util.ResponseMap;
import com.example.java.was.valueset.SuccessState;

@RestController
@ResponseBody
@RequestMapping("/api/*")
public class VocController {

	private static Logger logger = LoggerFactory.getLogger(VocController.class);
	
	@Autowired VocService vocService;
	
	/**
	 * 1000 : voc µî·Ï
	 */
	@PostMapping("/voc/regist")
    public HashMap<String, Object> registration(@RequestBody VocDto vocDto) {
		
		logger.info("voc registration : " + vocDto.toString());
		
		SuccessState successState = vocService.setVoc(vocDto);
		
		return ResponseMap.getResponseMap(successState);
    }
	
}

