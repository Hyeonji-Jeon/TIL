package com.exam.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class TodoDAO {
private Logger logger = LoggerFactory.getLogger(getClass());
	public TodoDAO() {
		logger.info("logger: {} ", "TodoDAO 생성자");
	}
}
