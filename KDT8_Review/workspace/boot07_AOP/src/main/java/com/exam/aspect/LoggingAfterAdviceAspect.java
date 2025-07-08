package com.exam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//부가기능 구현 클래스

@Component
//@Aspect
public class LoggingAfterAdviceAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	// advice + pointcut 같이 표현
	@After("execution(public String say*())")
	public void loggingPrint1() {
		 //로그처리 담당
		logger.info("LOGGER:{}", "@After 어드바이스1" );
	}
	
	// advice와 pointcut 분리
	@Pointcut("execution(public String sayEcho())")
	public void businessService() {}
	
	@After("businessService()")
	public void loggingPrint2() {
		 //로그처리 담당
		logger.info("LOGGER:{}", "@After 어드바이스2" );
	}
	
	@After("businessService()")
	public void loggingPrint3(JoinPoint point) {
		 //로그처리 담당
//		logger.info("LOGGER:{},{}", "@After 어드바이스3", point.getSignature() );
		logger.info("LOGGER:{},{}", "@After 어드바이스3", point.getSignature().getName() );
	}
}
