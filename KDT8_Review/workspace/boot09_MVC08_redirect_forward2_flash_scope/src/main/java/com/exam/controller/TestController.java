package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/redirect")
	public String aaa(Model m) {
		logger.info("LOGGER:{}", "redirect 호출");
		
		//request scope에 저장됨.
		m.addAttribute("userid", "홍길동");
		
		return "redirect:xxx";
	}
	
	@GetMapping("/redirect-flash")
	public String aaa2(RedirectAttributes m) {
		logger.info("LOGGER:{}", "redirect-flash 호출");
		
		m.addFlashAttribute("userid", "이순신");
		
		return "redirect:xxx";
	}
	@GetMapping("/xxx")
	public String main() {
		
		return "main";
	}
	
}
