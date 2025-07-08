package com.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.ChatService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ChatRestController {

	
	ChatService chatService;

	public ChatRestController(ChatService chatService) {
		this.chatService = chatService;
	}

	// http://localhost:8090/app/ai/embed/chat?question="smart"
	// http://localhost:8090/app/ai/embed/chat?question="Intelligent"
	@GetMapping("/ai/embed/chat")
	public  float[] generateEmbed(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		 float[] response = chatService.generateEmbed(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}

	// http://localhost:8090/app/ai/embed/chat2?question1="smart"&question2="Intelligent"
	// http://localhost:8090/app/ai/embed/chat2?question1="smart"&question2="dull"
	@GetMapping("/ai/embed/chat2")
	public  double generateAnswer1(@RequestParam String question1,
			                        @RequestParam String question2) {
		
		double response = chatService.generateEmbed2(question1, question2);
	
		return response;
	}	
	
}