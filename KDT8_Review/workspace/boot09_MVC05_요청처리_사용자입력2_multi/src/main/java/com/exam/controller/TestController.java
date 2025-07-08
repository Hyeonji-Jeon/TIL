package com.exam.controller;

import java.util.Arrays;
import java.util.List;
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
	
	//http://localhost:8090/app/main
	@GetMapping("/main")
	public String list() {
		return "main";
	}
	
	@PostMapping("/write3")
	public String write(LoginDTO dto) {
		
		logger.info("LOGGER:{}", dto);
		return "main";
	}
	
	@PostMapping("/write2")
	public String write2(@RequestParam("userid") String id, 
			            @RequestParam("passwd")  String pw,
			            @RequestParam("hobby")  String [] hobby) {

		
		logger.info("LOGGER:{},{},{}", id, pw, Arrays.toString(hobby));
		return "main";
	}
	
	@PostMapping("/write")
	public String write1(@RequestParam("userid") String id, 
			            @RequestParam("passwd")  String pw,
			            @RequestParam("hobby") List<String> hobby) {

		
		logger.info("LOGGER:{},{},{}", id, pw, hobby);
		return "main";
	}
	
	
	

}






