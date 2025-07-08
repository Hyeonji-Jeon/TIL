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
	
	//http://localhost:8090/app/main
	@GetMapping("/main")
	public String list() {
		return "main";
	}
	
	
	@PostMapping("/write7")
	public String write(@RequestParam("userid") String id, 
			            @RequestParam("passwd")  String pw,
			            @RequestParam("age")  Long age) {

		
		logger.info("LOGGER:{},{},{}", id, pw, age);
		return "main";
	}
	
	
	
	
	@PostMapping("/write6")
	public String write6(@RequestParam(name = "userid2",
	                                 required = false,
	                                 defaultValue = "xxx") String id, 
			            @RequestParam("passwd")  String pw) {

		
		logger.info("LOGGER:{},{}", id, pw);
		return "main";
	}
	
	@PostMapping("/write5")
	public String write5(@RequestParam Map<String, String> map) {

		logger.info("LOGGER:{}", map);
		return "main";
	}
	
	@PostMapping("/write4")
	public String write4(LoginDTO dto) {

		logger.info("LOGGER:{}", dto);
		return "main";
	}
	
	
	@PostMapping("/write3")
	public String write3(@RequestParam String userid, 
			            @RequestParam("passwd")  String pw) {

		
		logger.info("LOGGER:{},{}", userid, pw);
		return "main";
	}
	
	
	@PostMapping("/write2")
	public String write2(@RequestParam("userid") String id, 
			            @RequestParam("passwd")  String pw) {

		
		logger.info("LOGGER:{},{}", id, pw);
		return "main";
	}
	
	@PostMapping("/write1")
	public String write1(HttpServletRequest request) {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		
		logger.info("LOGGER:{},{}", userid, passwd);
		return "main";
	}
	

}






