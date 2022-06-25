package com.example.java.was.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.java.was.service.VocService;

@Controller
public class PageController {
	
	private static Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@GetMapping("/voc/list")
	public String getVocList(Model model) {
		logger.info("voc list page : ");
		
		return "voc/list";
	}
	
	@GetMapping("/voc/info/{vocId}")
	public String getVoc(Model model, @PathVariable("vocId") Long vocId) {
		logger.info("voc page : ");
		
		model.addAttribute("vocId", vocId);

		return "voc/info";
	}
}
