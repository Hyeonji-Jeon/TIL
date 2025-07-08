package com.exam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.exam.dao.DeptDAO;
import com.exam.dao.UserDAO;

@Service
public class DeptServiceImpl implements DeptService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Service에서 DAO 접근하고자 한다.
	DeptDAO deptDAO;
	UserDAO userDAO;
	
  // 기본생성자 사용 불가	
//	public DeptServiceImpl() {
//		logger.info("Logger:{}", "DeptServiceImpl 기본 생성자");
//	}


	// 생성자 주입
	public DeptServiceImpl(DeptDAO deptDAO, UserDAO userDAO) {
		logger.info("Logger:{}", "DeptServiceImpl 생성자" + deptDAO +"\t"+userDAO);
		this.deptDAO = deptDAO;
		this.userDAO = userDAO;
	}
	
}
