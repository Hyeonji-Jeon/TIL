package com.exam.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController  // @Controller + @ResponseBody
@Slf4j
public class MainController {

	/* 
	   http://localhost:8090/app/member/1
  	   http://localhost:8090/app/member/2
	*/
	@GetMapping("/member/{userid}")
	public String hello(@PathVariable String userid) {
		log.info("LOGGER: userid: {}", userid);
		return "Hello World:GET";
	}
	/* 
	   http://localhost:8090/app/member/1/inky4832
	   http://localhost:8090/app/member/2/kim4832
	*/
	@GetMapping("/member/{userid}/{email}")
	public String hello2(@PathVariable String userid,
			             @PathVariable String email
			              ) {
		log.info("LOGGER: userid: {}, email: {} ", userid, email);
		return "Hello World:GET";
	}
	

}






