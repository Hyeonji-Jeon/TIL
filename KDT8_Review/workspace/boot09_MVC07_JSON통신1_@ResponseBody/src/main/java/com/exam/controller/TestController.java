package com.exam.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.LoginDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/main") 
    public @ResponseBody LoginDTO login() {
		
		return new LoginDTO("홍길동", "1234");
	}
	
	@GetMapping("/main2")  
    public @ResponseBody ArrayList<LoginDTO> login2() {
		
		 ArrayList<LoginDTO> list = new ArrayList<>();
		 list.add(new LoginDTO("홍길동1", "1234"));
		 list.add(new LoginDTO("홍길동2", "1234"));
		 
		
		return list;
	}
	
}






