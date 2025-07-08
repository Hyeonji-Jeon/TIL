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

	// http://localhost:8090/app/ai/text/converter/chat?question="손흥민"
	@GetMapping("/ai/text/converter/chat")
	public FootBallPlayer generateAnswerWithBeanConverter(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		FootBallPlayer response = chatService.generateAnswerWithBeanConverter(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
		
		
	// http://localhost:8090/app/ai/text/converter/chat2?question="축구"
	@GetMapping("/ai/text/converter/chat2")
	public List<FootBallPlayer> generateAnswerWithConverter2(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		List<FootBallPlayer> response = chatService.generateAnswerWithBeanConverter2(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
	
	// http://localhost:8090/app/ai/text/converter/chat3?question="축구"
	@GetMapping("/ai/text/converter/chat3")
	public List<String> generateAnswerWithListConverter(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		List<String> response = chatService.generateAnswerWithListConverter(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
		
	// http://localhost:8090/app/ai/text/converter/chat4?question="축구"
	@GetMapping("/ai/text/converter/chat4")
	public Map<String, Object> generateAnswerWithMapConverter(@RequestParam String question) {
		
		log.info("LOGGER1: 질문: {}", question);
		Map<String, Object> response = chatService.generateAnswerWithMapConverter(question);
		log.info("LOGGER: 응닶: {}", response);
	
		return response;
	}
}