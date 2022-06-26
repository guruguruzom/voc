package com.example.java.was.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	private static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@GetMapping("/home")
	public String getHome(Model model) {
		logger.info("voc list page : ");
		
		return "page/home";
	}
}
