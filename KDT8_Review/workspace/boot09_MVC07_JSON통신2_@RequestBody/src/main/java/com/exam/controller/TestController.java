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
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/*
	 * Postman|Talend 도구 이용해서 요청
	 * 
	 * POST
	 * header : {
	 * 	'Content-Type' : application/json
	 * }
	 * 
	 * 요청 포멧 : 
	 * {
	 * 		"userid" : "aaa",
	 * 		"passwd" : "1234"
	 * }
	 */
	
	
	@PostMapping("/main1") 
    public @ResponseBody String login1(@RequestBody  LoginDTO dto) {
		logger.info("LOGGER:{}", dto);
		return "hello";
	}
	
	/*
	 * Postman|Talend 도구 이용해서 요청
	 * 
	 * POST
	 * header : {
	 * 	'Content-Type' : application/json
	 * }
	 * 
	 * 요청 포멧 : 
	 * [{
	 * 		"userid" : "aaa",
	 * 		"passwd" : "1234"
	 * },
	 * {
	 * 		"userid" : "bbb",
	 * 		"passwd" : "5678"
	 * }]
	 * 
	 * 
	 */
	
	@PostMapping("/main2") 
    public @ResponseBody void login2(@RequestBody ArrayList<LoginDTO> list) {
		logger.info("LOGGER:{}", list);
	}
	
	
	
}














