package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.FootBallPlayer;
import com.exam.service.ChatService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ChatRestController {

	
	ChatService chatService;

	public ChatRestController(ChatService chatService) {
		this.chatService = chatService;
	}

	// http://localhost:8090/app/ai/text/entity/chat?question="손흥민"
	@GetMapping("/ai/text/entity/chat")
	public FootBallPlayer generateAnswerWithEntity(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		FootBallPlayer response = chatService.generateAnswerWithEntity(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
		
	// http://localhost:8090/app/ai/text/entity/chat2?question="축구"
	@GetMapping("/ai/text/entity/chat2")
	public List<FootBallPlayer> generateAnswerWithEntity2(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		List<FootBallPlayer> response = chatService.generateAnswerWithEntity2(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
}