package com.exam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	   //전역 예외처리
		@ExceptionHandler(value = { IllegalArgumentException.class,
				NullPointerException.class } )
		public String errorPage(Exception e, Model m) {
			logger.info("LOGGER:{}", e.getMessage());
			
			m.addAttribute("errorMessage", e.getMessage());
			return "errorPage";  // errorPage.jsp
		}
		
}
