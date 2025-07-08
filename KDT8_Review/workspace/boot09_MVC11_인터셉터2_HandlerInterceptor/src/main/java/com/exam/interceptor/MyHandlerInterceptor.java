package com.exam.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class MyHandlerInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// 주요 기능: 로그인여부 확인
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler)
			throws Exception {
		logger.info("LOGGER: {}, {}", "preHandle 호출", handler);
		
		//로그인 여부 체크 
		HttpSession session = request.getSession();
		String userid =(String)session.getAttribute("userid");
		if(userid!=null) {
			//로그인된 상태
			
		}else {
			//로그인 안된 상태
			//response.sendRedirect("loginForm");
		}
		
		
		
		return true;
	}
	
	// 주요 기능: 모델추가 및 뷰 변경
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView mav) throws Exception {

		// 모델추가 및 변경
		//mav.addObject("userid", "홍길동");
		
		// 뷰변경
		//mav.setViewName("hello");  //hello.jsp
		
		logger.info("LOGGER: {}", "postHandle 호출");
	}

	// 주요기능: cleanup 
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			Exception ex)
			throws Exception {

		logger.info("LOGGER: {}", "afterCompletion 호출");
	}

	
}
