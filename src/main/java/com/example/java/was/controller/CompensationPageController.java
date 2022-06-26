package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.java.was.service.CompensationService;


@Controller
public class CompensationPageController {
	private static Logger logger = LoggerFactory.getLogger(CompensationPageController.class);
	
	@Autowired CompensationService compensationService;
	
	
	@GetMapping("/compensation/list")
	public String l(Model model) throws Exception {
		
		logger.info("compensation list : ");
		
		HashMap<String, Object> map = compensationService.getCompensationList();
		
		model.addAttribute("response", map);
	
		return "compensation/list";
    }
	
//	@GetMapping("/compensation/list")
//	public HashMap<String, Object> registration() throws Exception {
//		
//		logger.info("compensation list : ");
//	
//		return compensationService.getCompensationList();
//    }
}
