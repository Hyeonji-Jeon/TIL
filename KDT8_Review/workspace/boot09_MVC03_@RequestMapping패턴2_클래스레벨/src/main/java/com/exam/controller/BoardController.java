package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/board/list")
	public String list() {
		logger.info("LOGGER:{}", "/board/list 호출");
		return "sayHello";
	}
	@RequestMapping("/board/delete")
	public String delete() {
		logger.info("LOGGER:{}", "/board/list 호출");
		return "sayHello";
	}
	@RequestMapping("/board/update")
	public String update() {
		logger.info("LOGGER:{}", "/board/list 호출");
		return "sayHello";
	}
	@RequestMapping("/board/insert")
	public String insert() {
		logger.info("LOGGER:{}", "/board/list 호출");
		return "sayHello";
	}
	
}






