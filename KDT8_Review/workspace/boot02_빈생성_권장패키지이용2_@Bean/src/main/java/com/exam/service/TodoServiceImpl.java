package com.exam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class TodoServiceImpl {
private Logger logger = LoggerFactory.getLogger(getClass());
	public TodoServiceImpl() {
		logger.info("logger: {} ", "TodoServiceImpl 생성자");
	}
}
