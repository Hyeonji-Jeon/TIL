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
@SessionAttributes(names = {"email","address"}) //이게 있어야 session scope
public class TestController2 {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ServletContext application;
	
	@GetMapping("/get")
	public String set(Model m) { // 내부적으로 객체생성됨.
	
		//1. request scope
		String userid =(String) m.getAttribute("userid");
		
		int passwd = 0;
		if(m.getAttribute("passwd") != null)		
		passwd  = (Integer) m.getAttribute("passwd");

		//2. session scope
		String email =(String) m.getAttribute("email");
		String address =(String) m.getAttribute("address");
		
		//3. application scope
		String phone = (String) m.getAttribute("phone");
		
		logger.info("request Scope:{}, {}", userid, passwd);
		logger.info("session Scope:{}, {}", email, address);
		logger.info("application Scope:{}", phone);
		
		return "main";
	}
	
	
	

}






