package com.exam.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("deptService")
public class DeptServiceImpl implements DeptService{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public String sayEcho() {
		logger.info("LOGGER:{}", "sayEcho 호출" );
		
		int num = 10;
		int result = num/2; //에러발생
		
		
		return "안녕하세요";
	}

	@Override
	public List<String> list() {
		return Arrays.asList("홍길동","이순신");
	}

}
