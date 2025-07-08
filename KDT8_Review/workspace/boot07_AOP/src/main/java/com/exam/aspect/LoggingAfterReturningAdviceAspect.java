package com.exam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//부가기능 구현 클래스

@Component
//@Aspect
public class LoggingAfterReturningAdviceAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	// advice + pointcut 같이 표현
	@AfterReturning("bean(*Service)")
	public void loggingPrint1() {
		 //로그처리 담당
		logger.info("LOGGER:{}", "@AfterReturning 어드바이스1" );
	}
	
	@AfterReturning(pointcut = "bean(*Service)", returning = "xxx")
	public void loggingPrint2(Object xxx) {
		 //로그처리 담당
		logger.info("LOGGER:{}, {}", "@AfterReturning 어드바이스2", xxx );
	}
	
	@AfterReturning(pointcut = "bean(*Service)", returning = "xxx")
	public void loggingPrint3(JoinPoint point,Object xxx) {
		 //로그처리 담당
		logger.info("LOGGER:{}, {}, {}", "@AfterReturning 어드바이스3", 
				 xxx, point.getSignature().getName() );
	}
	
	// advice와 pointcut 분리
	@Pointcut("bean(*Service)")
	public void businessService() {}
	
	@AfterReturning(pointcut = "businessService()", returning = "xxx")
	public void loggingPrint4(Object xxx) {
		 //로그처리 담당
		logger.info("LOGGER:{}, {}", "@AfterReturning 어드바이스4", xxx );
	}
	
	
	
}
