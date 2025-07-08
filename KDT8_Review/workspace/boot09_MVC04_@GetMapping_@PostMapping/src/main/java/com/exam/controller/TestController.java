package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/main")
	public String list() {
		return "main";
	}

	
//	@RequestMapping(value = "/write", method = RequestMethod.GET )
	@GetMapping("/write")
	public String writeForm() {
		logger.info("LOGGER:{}", "GET-writeForm");
		return "main";
	}
	
//	@RequestMapping(value = "/write", method = RequestMethod.POST )
	@PostMapping("/write")
	public String write() {
		logger.info("LOGGER:{}", "POST-write");
		return "main";
	}
	

}






