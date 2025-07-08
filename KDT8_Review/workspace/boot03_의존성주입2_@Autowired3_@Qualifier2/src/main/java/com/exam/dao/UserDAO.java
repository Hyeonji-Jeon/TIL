package com.exam.dao;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("user")
public class UserDAO implements CommonDAO{
	private Logger logger = LoggerFactory.getLogger(getClass());
	public UserDAO() {
		logger.info("Logger:{}", "UserDAO 생성자" + this);
	}
	@Override
	public List<String> list() {
		return Arrays.asList("홍길동1","홍길동2");
	}
}
