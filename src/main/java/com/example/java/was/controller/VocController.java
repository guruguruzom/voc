package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.was.domain.RegistDto;
import com.example.java.was.domain.VocDto;
import com.example.java.was.service.VocService;

@RestController
@ResponseBody
@RequestMapping("/api/*")
public class VocController {

	private static Logger logger = LoggerFactory.getLogger(VocController.class);
	
	@Autowired VocService vocService;
	
	/***
	 * 1000 : voc 등록
	 * @param vocDto
	 * @return
	 * @throws Exception
	 */
	
	@PostMapping("/voc/regist")
    public HashMap<String, Object> regist(@RequestBody RegistDto registDto) throws Exception {
		
		logger.info("voc regist : " + registDto.toString());
		
		return vocService.setVoc(registDto);
    }
	
	/***
	 * 2001 : 이의제기 여부 등록
	 * @param vocId
	 * @param stateCode
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/voc/state/{vocId}")
	public HashMap<String, Object> registration(@PathVariable("vocId") Long vocId,
			@RequestParam(value="stateCode",required=false, defaultValue="none") String stateCode) throws Exception {
		
		logger.info("state set : " + vocId);
		
		return vocService.setState(vocId,stateCode);
	}
}

