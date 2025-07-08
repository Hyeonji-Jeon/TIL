package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/list")
	public String list() {
		logger.info("LOGGER:{}", "/member/list 호출");
		return "sayHello";
	}
	@RequestMapping("/delete")
	public String delete() {
		logger.info("LOGGER:{}", "/member/list 호출");
		return "sayHello";
	}
	@RequestMapping("/update")
	public String update() {
		logger.info("LOGGER:{}", "/member/list 호출");
		return "sayHello";
	}
	@RequestMapping("/insert")
	public String insert() {
		logger.info("LOGGER:{}", "/member/list 호출");
		return "sayHello";
	}
	
	
}






