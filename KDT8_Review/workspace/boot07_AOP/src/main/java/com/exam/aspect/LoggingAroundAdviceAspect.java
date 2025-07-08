package com.exam.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//부가기능 구현 클래스

@Component
//@Aspect
public class LoggingAroundAdviceAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	// advice + pointcut 같이 표현
	@Around("execution(public String say2*()) || bean(*Service)")
	public Object loggingPrint1(ProceedingJoinPoint point) {
	
		Object retval = null;
		
		try {
			logger.info("LOGGER: {}" , "@Before 처리");
			retval = point.proceed();
			logger.info("LOGGER: {}, {} " , "@After 처리", retval);			
			
		} catch (Throwable e) {
			logger.info("LOGGER: {}" , "@AfterThrowing 처리");						
		}
		
		return retval; // @AfterReturning 처리
	}
	
	// advice와 pointcut 분리
	@Pointcut("execution(public String say2*()) || bean(*Service)")
	public void businessService() {}
	
	@Around("businessService()")
	Object loggingPrint2(ProceedingJoinPoint point) {
			
	    Object retval = null;
		
		try {
			logger.info("LOGGER: {}" , "@Before 처리2");
			retval = point.proceed();
			logger.info("LOGGER: {}, {} " , "@After 처리2", retval);			
			
		} catch (Throwable e) {
			logger.info("LOGGER: {}" , "@AfterThrowing 처리2");						
		}
		
		return retval; // @AfterReturning 처리
	}
}
