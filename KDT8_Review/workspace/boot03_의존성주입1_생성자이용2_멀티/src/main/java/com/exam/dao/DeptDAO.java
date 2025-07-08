package com.exam.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public DeptDAO() {
		logger.info("Logger:{}", "DeptDAO 생성자" + this);
	}

	
}
