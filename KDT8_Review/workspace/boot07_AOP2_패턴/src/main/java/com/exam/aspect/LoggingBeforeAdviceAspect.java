package com.exam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//부가기능 구현 클래스

@Component
@Aspect
public class LoggingBeforeAdviceAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
		
	// advice와 pointcut 분리
	
	@Before("com.exam.aop.pointcut.CommonPointCut.businessService()")
	public void loggingPrint2() {
		 //로그처리 담당
		logger.info("LOGGER:{}", "@Before 어드바이스2" );
	}
	
	@Before("com.exam.aop.pointcut.CommonPointCut.businessService()")
	public void loggingPrint3(JoinPoint point) {
		 //로그처리 담당
//		logger.info("LOGGER:{},{}", "@Before 어드바이스3", point.getSignature() );
		logger.info("LOGGER:{},{}", "@Before 어드바이스3", point.getSignature().getName() );
	}
	
}
