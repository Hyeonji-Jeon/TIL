package com.exam.dao;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public DeptDAO() {
		logger.info("Logger:{}", "DeptDAO 생성자" + this);
	}
	
	//데이터 리턴하는 메서드
	public List<String>  list(){
		return Arrays.asList("홍길동","이순신");
	}

	
}
