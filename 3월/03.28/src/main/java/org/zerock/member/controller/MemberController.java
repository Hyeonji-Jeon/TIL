package org.zerock.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member")
@Log4j2
public class MemberController {

	
	@GetMapping("login")
	public void login( @RequestParam(name = "error", required = false)String error ) {
		
		log.info("==============================");
		log.info("error: " +error);
	}
	
}











