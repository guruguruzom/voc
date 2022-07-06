package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.java.was.service.impl.CompensationServiceImpl;


@Controller
public class CompensationPageController {
	private static Logger logger = LoggerFactory.getLogger(CompensationPageController.class);
	
	@Autowired CompensationServiceImpl compensationService;
	
	/***
	 * 3100 : 배상정보 리스트 페이지
	 * @param compensationDto
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/compensation/list")
	public String getCompensationList(Model model) throws Exception {
		
		logger.info("compensation list : ");
		
		HashMap<String, Object> map = compensationService.getCompensationList();
		
		model.addAttribute("response", map);
	
		return "compensation/list";
    }
}
