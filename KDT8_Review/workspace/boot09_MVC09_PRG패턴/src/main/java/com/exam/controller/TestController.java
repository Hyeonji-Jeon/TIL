package com.exam.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.LoginDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/main")
	public String list() {
		return "main";
	}
	
	
	@PostMapping("/write")
	public String write(@RequestParam("userid") String id, 
			            @RequestParam("passwd")  String pw,
			            @RequestParam("age")  Long age) {

		
		logger.info("LOGGER:{},{},{}", id, pw, age);
		
//		return "success";          // PRG패턴 미적용
		return "redirect:success"; // PRG패턴 적용
	}
	
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	

}






