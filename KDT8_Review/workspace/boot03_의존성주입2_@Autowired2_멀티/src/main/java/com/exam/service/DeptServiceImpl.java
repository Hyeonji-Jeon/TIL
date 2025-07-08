package com.exam.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dao.DeptDAO;
import com.exam.dao.UserDAO;

@Service
public class DeptServiceImpl implements DeptService{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Service에서 DAO 접근하고자 한다.
	
	@Autowired
	DeptDAO deptDAO;
	
	
	@Autowired
	UserDAO userDAO;


	
}
