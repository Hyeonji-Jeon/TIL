package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/main")
	public String list() {
		return "main";
	}
	
	// 요청맵핑값과 method 가 모두 다른 경우1
	@RequestMapping(value = "/req/get", method = RequestMethod.GET )
	public String req_get() {
		logger.info("LOGGER:{}", "GET");
		return "main";
	}
	
	@RequestMapping(value = "/req/post", method = RequestMethod.POST )
	public String req_post() {
		logger.info("LOGGER:{}", "POST");
		return "main";
	}
	

	// 요청맵핑값은 동일하고 method 가 다른 경우2
	@RequestMapping(value = "/write", method = RequestMethod.GET )
	public String writeForm() {
		logger.info("LOGGER:{}", "GET-writeForm");
		return "main";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST )
	public String write() {
		logger.info("LOGGER:{}", "POST-write");
		return "main";
	}
	

}






