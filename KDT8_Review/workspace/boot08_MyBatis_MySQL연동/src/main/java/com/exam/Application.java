package com.exam;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.dto.DeptDTO;
import com.exam.service.DeptService;



@SpringBootApplication
public class Application implements CommandLineRunner{

	//1. Logger 얻기
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DeptService service;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application");
		
		//데이터 저장
		//int n = service.save(new DeptDTO(90,"인사", "부산"));
		
		//데이터 수정
//		int n2 = service.update(new DeptDTO(90,"개발", "서울"));
		
		//데이터 삭제
		//int n3 = service.delete(90);
		
		//트랜잭션 실습
		int n4 = service.tx(new DeptDTO(90,"인사", "부산"), 60); 
		
		List<DeptDTO> list = service.findAll();
		logger.info("LOGGER list : {}",  list);
		
	}

}
