package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class TodoController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public TodoController() {
		logger.info("logger: {} ", "TodoController 생성자");
	}
}
