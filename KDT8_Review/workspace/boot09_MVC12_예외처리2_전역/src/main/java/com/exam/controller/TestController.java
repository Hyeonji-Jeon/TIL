package com.exam.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/main")
	public String main() {
		logger.info("LOGGER: {}", "main 호출");
		
		//예외발생
		if(true)throw new IllegalArgumentException("IllegalArgumentException 예외발생");
		return "main";
	}
	
	@GetMapping("/main2")
	public String main2() {
		logger.info("LOGGER: {}", "main2 호출");
		
		//예외발생
		if(true)throw new NullPointerException("NullPointerException 예외발생");
		return "main";
	}
	
	
	
}






