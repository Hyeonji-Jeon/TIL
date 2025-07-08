package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@GetMapping(value={"/login"})
	public String showHomePage() {
		return "loginForm";
	}

}
