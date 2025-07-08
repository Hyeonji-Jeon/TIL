package com.exam.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Controller + @ResponseBody
public class MainController {

	// http://localhost:8090/app/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello World:GET";
	}
	
	@PostMapping("/hello")
	public String hello2() {
		return "Hello World:POST";
	}
	
	@PutMapping("/hello")
	public String hello3() {
		return "Hello World:PUT";
	}
	
	@DeleteMapping("/hello")
	public String hello4() {
		return "Hello World:DELETE";
	}
	
}
