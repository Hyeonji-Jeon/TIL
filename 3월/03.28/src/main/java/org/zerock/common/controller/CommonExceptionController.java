package org.zerock.common.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zerock.common.exception.DataNotFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class CommonExceptionController {

	@ExceptionHandler(DataNotFoundException.class)
	public String notFound() {
		log.info("Data Not Found");
		
		return "404";
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String notValid(MethodArgumentNotValidException exception) {
		
		log.info(exception);
		
		return "404";
	}
	
}







