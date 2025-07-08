package com.exam.controller;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// 리소스번들 참조하는 API 주입
	MessageSource messageSource;
	
	public TestController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@GetMapping("/main")
	//@ResponseBody
	public String main() {
		logger.info("LOGGER: {}", "main 호출");
		
		//현재 로케일 정보
		// 요청헤더값 중에서 accept-language: ko-kr, ko  값이고 이것이 기본 Locale 임.
		Locale locale = LocaleContextHolder.getLocale();
		logger.info("LOGGER: 현재 Locale : {}", locale );
		
		// 메세지 참조하기
		//getMessage(String code, Object[] args, String defaultMessage, Locale locale)
		String message = messageSource.getMessage("greeting", new String[] {"AAA","BBB"}, "기본 인사말", locale);
		
		logger.info("LOGGER: message : {}", message );
		
		
		return "main";
	}
	
	
	
	
}






