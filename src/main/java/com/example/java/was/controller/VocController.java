package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.domain.VocDto;
import com.example.java.was.service.VocService;

@RestController
@ResponseBody
@RequestMapping("/api/*")
public class VocController {

	private static Logger logger = LoggerFactory.getLogger(VocController.class);
	
	@Autowired VocService vocService;
	
	/**
	 * 1000 : voc 등록
	 */
	@PostMapping("/voc/regist")
    public HashMap<String, Object> regist(@RequestBody VocDto vocDto) {
		
		logger.info("voc regist : " + vocDto.toString());
		
		return vocService.setVoc(vocDto);
    }
	
	/**
	 * 1001 : voc 목록 조회
	 */
	@GetMapping("/voc/list")
    public HashMap<String, Object> vocList() {
		
		
		logger.info("voc list : ");
		
		return vocService.getVocList();
    }
	
	/**
	 * 1002 : voc 상세 조회
	 * @throws Exception 
	 */
	@GetMapping("/voc/{vocId}")
    public HashMap<String, Object> getVoc(@PathVariable("vocId") Long vocId) throws Exception {
		
		logger.info("voc detail : " + vocId);
		
		return vocService.getVoc(vocId);
    }
}

