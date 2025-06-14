package com.exam.service;

import org.springframework.ai.chat.model.ChatResponse;

public interface ChatService {

	public String generateAnswerWithVectorStore(String question);

}
