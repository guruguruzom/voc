package com.example.java.was.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.java.was.service.VocService;

@Controller
public class VocPageController {
	
	private static Logger logger = LoggerFactory.getLogger(VocPageController.class);
	
	@Autowired VocService vocService;
	
	/***
	 * 1001 : voc list
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/voc/list")
	public String getVocList(Model model) throws Exception {
		
		logger.info("voc list page : ");
		
		HashMap<String, Object> map = vocService.getVocList();
		
		model.addAttribute("response", map);
		
		return "voc/list";
	}
	

	/***
	 * 1002 : voc 상세
	 * @param vocId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/voc/{vocId}")
    public String getVoc(Model model, @PathVariable("vocId") Long vocId) throws Exception  {
		
		logger.info("voc detail : " + vocId);
		
		HashMap<String, Object> map = vocService.getVoc(vocId);
		
		model.addAttribute("response", map);
		
		return "voc/info";
    }
}
