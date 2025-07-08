package com.exam.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public UserDAO() {
		logger.info("Logger:{}", "UserDAO 생성자" + this);
	}

	
}
