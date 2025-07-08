package com.exam.controller;

import java.util.Enumeration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// 서블릿 쿠키 코드
	@GetMapping("/set")
	public String set(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie c = new Cookie("userid", "홍길동");
		c.setMaxAge(3600); // 1시간
		response.addCookie(c);
	
		return "main";
	}
	
	// 서블릿 쿠키 코드
		@GetMapping("/get")
		public String get(HttpServletRequest request, HttpServletResponse response) {
			
			Cookie [] cookies = request.getCookies();
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				logger.info("LOGGER:{}={}", name, value);
			}
		
			return "main";
		}
		
	// spring 쿠키 얻기
		@GetMapping("/get2")
		public String get2(@CookieValue("userid") String s,
							@CookieValue("JSESSIONID") String s2) {
	
			logger.info("LOGGER:userid={}", s);
			logger.info("LOGGER:JSESSIONID={}", s2);
			return "main";
		}	

}






