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
@Aspect
public class LoggingAfterAdviceAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	
	@After("com.exam.aop.pointcut.CommonPointCut.businessService2()")
	public void loggingPrint2() {
		 //로그처리 담당
		logger.info("LOGGER:{}", "@After 어드바이스2" );
	}
	
	@After("com.exam.aop.pointcut.CommonPointCut.businessService2()")
	public void loggingPrint3(JoinPoint point) {
		 //로그처리 담당
//		logger.info("LOGGER:{},{}", "@After 어드바이스3", point.getSignature() );
		logger.info("LOGGER:{},{}", "@After 어드바이스3", point.getSignature().getName() );
	}
}
