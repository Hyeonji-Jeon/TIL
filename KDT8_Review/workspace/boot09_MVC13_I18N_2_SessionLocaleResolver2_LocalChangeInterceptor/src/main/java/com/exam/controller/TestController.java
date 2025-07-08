package com.exam.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	
	// http://localhost:8090/app/main?lang=en|ja|ko
	@GetMapping("/main")
	public String main() {
		logger.info("LOGGER: {}, {}", "main 호출");
		Locale locale = LocaleContextHolder.getLocale();
		logger.info("LOGGER: 현재 Locale : {}", locale );
		return "main";
	}
	
	
}






