package com.exam;


import java.util.List;

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

	@Autowired
	ApplicationContext ctx; // AnnotationConfigApplicationContext 의존성주입됨
	
	//1. Logger 얻기
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Application: {} ", ctx);
		
		// 빈참조
		DeptServiceImpl service =
				ctx.getBean("xxx", DeptServiceImpl.class);
		
		DeptServiceImpl service2 =
				ctx.getBean("xxx", DeptServiceImpl.class);
		
		
		logger.info("service1:{}, service2:{}" , service, service2);
		logger.info("service == service2: {}" , (service==service2));
		
	}

}
