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

	// http://localhost:8090/app/ai/text/chat?question="자바개발자가 알아야될 스킬 알려줘"
	@GetMapping("/ai/text/chat")
	public String generateAnswer(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		String response = chatService.generateAnswer(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
	
	// http://localhost:8090/app/ai/text/chat
	/*
	     Content-Type:  text/plain
	     body:   자바개발자가 알아야될 스킬 알려줘
	
	*/
	@PostMapping("/ai/text/chat")
	public String generateAnswer2(@RequestBody String content) {
		
		log.info("LOGGER1: 질문: {}", content);
		String response = chatService.generateAnswer(content);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
	
	
	// http://localhost:8090/app/ai/text/chat1?question="자바개발자가 알아야될 스킬 알려줘"
	@GetMapping("/ai/text/chat1")
	public String generateAnswerWithOptions(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		String response = chatService.generateAnswerWithOptions(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
	

	
	
	// http://localhost:8090/app/ai/text/chat3?question="이순신 장군"
	@GetMapping("/ai/text/chat3")
	public String generateAnswerWithPromptTemplate(@RequestParam String question) {
		
		return chatService.generateAnswerWithPromptTemplate(question);
	}
	
	
	// http://localhost:8090/app/ai/text/chat4?question="유관순"
	@GetMapping("/ai/text/chat4")
	public String generateAnswerWithPromptTemplateAndFile(@RequestParam String question) {
		
		return chatService.generateAnswerWithPromptTemplateAndFile(question);
	}
	
	
		
	// http://localhost:8090/app/ai/text/chat5?question="야구"
	// http://localhost:8090/app/ai/text/chat5?question=""   // 비워두거나 잘못된 값 지정 
	@GetMapping("/ai/text/chat5")
	public String generateUserAndSystemAnswer(@RequestParam String question) {
		
		String response = chatService.generateUserAndSystemAnswer(question);
		return response;
	}
		
	
}