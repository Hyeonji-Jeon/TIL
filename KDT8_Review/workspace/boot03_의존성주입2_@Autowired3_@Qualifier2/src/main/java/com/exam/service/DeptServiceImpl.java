package com.exam.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.exam.dao.CommonDAO;
import com.exam.dao.DeptDAO;
import com.exam.dao.UserDAO;

@Service("xxx")
public class DeptServiceImpl implements DeptService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Service에서 DAO 접근하고자 한다.
	
	@Autowired
	@Qualifier("dept")
	CommonDAO dao;


	public List<String> list() {
		return dao.list();
	}
}
