package com.exam.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.exam.dao.CommonDAO;
import com.exam.dao.DeptDAO;
import com.exam.dao.UserDAO;

@Service("xxx")
public class DeptServiceImpl implements DeptService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Service에서 DAO 접근하고자 한다.
	CommonDAO dao;

	// 생성자 주입
	public DeptServiceImpl( @Qualifier("dept")  CommonDAO dao) {
		logger.info("Logger:{}", "DeptServiceImpl 생성자");
		this.dao = dao;
	}
	public List<String> list() {
		return dao.list();
	}
}
