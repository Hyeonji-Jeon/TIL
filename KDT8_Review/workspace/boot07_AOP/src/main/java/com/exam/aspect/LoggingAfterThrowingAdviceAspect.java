package com.exam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//부가기능 구현 클래스

@Component
//@Aspect
public class LoggingAfterThrowingAdviceAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	// advice + pointcut 같이 표현
	@AfterThrowing("within(com.exam.service.*)")
	public void loggingPrint1() {
		 //로그처리 담당
		logger.info("LOGGER:{}", "@AfterThrowing 어드바이스1" );
	}
	
	@AfterThrowing(pointcut = "within(com.exam.service.*)",
			 throwing = "ex")
	public void loggingPrint2(Exception ex) {
		 //로그처리 담당
		logger.info("LOGGER:{},{}", "@AfterThrowing 어드바이스2", ex.getMessage() );
	}
	
	// advice와 pointcut 분리
	@Pointcut("within(com.exam.service.*)")
	public void businessService() {}
	
	@AfterThrowing(pointcut = "businessService()",
			 throwing = "ex")
	public void loggingPrint3(Exception ex) {
		logger.info("LOGGER:{},{}", "@AfterThrowing 어드바이스3", ex.getMessage() );
	}
	
}
