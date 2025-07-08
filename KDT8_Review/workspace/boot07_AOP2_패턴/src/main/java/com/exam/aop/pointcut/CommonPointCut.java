package com.exam.aop.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCut {

	@Pointcut("execution(public String sayEcho())")
	public void businessService() {}
	
	@Pointcut("bean(*Service)")
	public void businessService2() {}
}
