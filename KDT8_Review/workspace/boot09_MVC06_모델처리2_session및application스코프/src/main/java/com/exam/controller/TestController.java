package com.exam.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.LoginDTO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes(names = {"email","address"})
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ServletContext application;
	
	@GetMapping("/set")
	public String set(Model m) { // 내부적으로 객체생성됨.
	
		//1. request scope에 저장됨.
		m.addAttribute("userid", "홍길동" );
		m.addAttribute("passwd", 1234 );
		
		//2. session scope에 저장
		m.addAttribute("email", "aaa@daum.net" );
		m.addAttribute("address", "부산" );
		
		//3. application scope에 저장
		application.setAttribute("phone","010-1234-5678");
		
		return "main";
	}
	
	
	

}






