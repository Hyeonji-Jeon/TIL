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

	
	// http://localhost:8090/app/ai/vectorstore/chat2?question="풀스택 또는 프런트엔드 개발자 구인 목록 알려줘"
	@GetMapping("/ai/vectorstore/chat2")
	public String generateAnswerWithVectorStoreSimilaritySearch(@RequestParam String question) {
		
		String response = chatService.generateAnswerWithVectorStoreSimilaritySearch(question);
	
		return response;
	}	
	
}