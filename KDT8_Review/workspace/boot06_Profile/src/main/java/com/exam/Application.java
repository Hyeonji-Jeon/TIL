package com.exam;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Application implements CommandLineRunner{

	//1. Logger 얻기
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application");
		
		//2. log 레벨 메서드 호출
		logger.trace("trace 입니다.");
		logger.trace("trace {}", "입니다.");
		logger.debug("debug {}", "입니다.");
		logger.info("info {}", "입니다.");
		logger.warn("warn {}", "입니다.");
		logger.error("error {}", "입니다.");
		
	}

}
