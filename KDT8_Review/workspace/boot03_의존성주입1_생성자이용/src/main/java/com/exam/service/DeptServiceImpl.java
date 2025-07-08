package com.exam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.exam.dao.DeptDAO;

@Service
public class DeptServiceImpl implements DeptService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Service에서 DAO 접근하고자 한다.
	DeptDAO dao;
	
	// 생성자 주입
	public DeptServiceImpl(DeptDAO dao) {
		logger.info("Logger:{}", "DeptServiceImpl 생성자" + dao);
		this.dao = dao;
	}
	
}
