package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// 요청 URL: http://localhost:8090/컨텍스트명/서블릿맵핑명/요청맵핑명  (***********)
	
	// http://localhost:8090/list
	@RequestMapping("/list")
	public String aaa() {
		logger.info("LOGGER:{}", "aaa 호출");
		//return "/WEB-INF/views/sayHello.jsp";
		return "sayHello";
	}
	
	
	// http://localhost:8090/write
	@RequestMapping("/write")
    public String bbb() {
    	logger.info("LOGGER:{}", "bbb 호출");
    	//return "/WEB-INF/views/sayHello.jsp";
    	return "sayHello";
	}
}
