package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Controller(value = "TodoController")
public class TodoController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	//생성자
	public TodoController() {
		logger.info("logger: {} ", "TodoController 생성자");
	}
	
	//초기화
	@PostConstruct
	public void init() {
		logger.info("logger: {} ", "init 메서드");
	}
	
	//cleanup
	@PreDestroy
	public void cleanup() {
		logger.info("logger: {} ", "cleanup 메서드");		
	}
	
}
