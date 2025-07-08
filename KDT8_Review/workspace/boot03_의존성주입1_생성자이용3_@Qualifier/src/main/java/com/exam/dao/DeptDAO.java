package com.exam.dao;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("dept")
public class DeptDAO implements CommonDAO{
	private Logger logger = LoggerFactory.getLogger(getClass());
	public DeptDAO() {
		logger.info("Logger:{}", "DeptDAO 생성자" + this);
	}
	@Override
	public List<String> list() {
		return Arrays.asList("관리1","관리2");
	}
}
