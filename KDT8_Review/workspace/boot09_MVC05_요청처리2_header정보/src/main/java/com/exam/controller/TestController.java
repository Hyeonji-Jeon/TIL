package com.exam.controller;

import java.util.Enumeration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/main")
	public String list(@RequestHeader("user-agent") String s,
			           @RequestHeader("accept-language") String s2) {
	
		 logger.info("LOGGER:user-agent={}", s);
		 logger.info("LOGGER:accept-language={}", s2);
		return "main";
	}
	
	@GetMapping("/main1")
	public String list1(HttpServletRequest request) {
		
	 Enumeration<String> enu = request.getHeaderNames();
	 while(enu.hasMoreElements()) {
		 String key = enu.nextElement();
		 String value = request.getHeader(key);
		 
		 logger.info("LOGGER:{}={}", key, value);
	 }
		
		return "main";
	}

}






