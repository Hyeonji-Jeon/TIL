package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/list")
	public String list() {
		logger.info("LOGGER:{}", "list 호출");
		return "sayHello";
	}
	
	@RequestMapping(value =  "/list2")
	public String list2() {
		logger.info("LOGGER:{}", "list2 호출");
		return "sayHello";
	}
	
	@RequestMapping(value={"/list3", "/select"})
	public String list3() {
		logger.info("LOGGER:{}", "list3  select 호출");
		return "sayHello";
	}
	
	@RequestMapping(value =  "/board/list")
	public String board_list() {
		logger.info("LOGGER:{}", "board_list 호출");
		return "sayHello";
	}
	
	@RequestMapping(value =  "/write*")
	public String write() {
		logger.info("LOGGER:{}", "write* 호출");
		return "sayHello";
	}
	
	@RequestMapping(value =  "/update/*")  // *는 하나의 디렉터리경로 의미
	public String update() {
		logger.info("LOGGER:{}", "update/* 호출");
		return "sayHello";
	}
	
	@RequestMapping(value =  "/del/*/some")  // *는 하나의 디렉터리경로 의미
	public String del_some() {
		logger.info("LOGGER:{}", "/del/*/some 호출");
		return "sayHello";
	}
	
	//http://localhost:8090/app/delete/aaa
	//http://localhost:8090/app/delete/aaa/bbb
	//http://localhost:8090/app/delete/aaa/bbb/ccc
	@RequestMapping(value =  "/delete/**")  // **는 여러개의 디렉터리경로 의미
	public String delete() {
		logger.info("LOGGER:{}", "/delete/** 호출");
		return "sayHello";
	}
	
	// 다음코드는 에러 발생됨. 해결:
	//https://docs.spring.io/spring-boot/docs/3.2.12/reference/html/web.html#web.servlet.spring-mvc.content-negotiation
	// spring.mvc.pathmatch.matching-strategy=ant-path-matcher
	@RequestMapping(value =  "/search/**/some")  // **는 여러개의 디렉터리경로 의미
	public String search() {
		logger.info("LOGGER:{}", "/search/**/some 호출");
		return "sayHello";
	}
}






