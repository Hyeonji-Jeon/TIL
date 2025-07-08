package com.exam;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.exam.service.DeptServiceImpl;



@SpringBootApplication
public class Application implements CommandLineRunner{

	//1. Logger 얻기
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ApplicationContext ctx;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application");
		
		DeptServiceImpl serviceImple =
				ctx.getBean("deptService", DeptServiceImpl.class);
		
	  try {	
		String mesg = serviceImple.sayEcho();
		logger.info("sayEcho 호출: {}",  mesg);
	  }catch(Exception e) {
		logger.error("sayEcho 호출시 에러: {}",  e.getMessage());  
	  }
		
	}

}
