package com.exam.service;

import org.springframework.ai.chat.model.ChatResponse;

public interface ChatService {

	public String generateAnswer(String question);
	public String generateAnswerWithOptions(String question);
	
	
	public String generateAnswerWithPromptTemplate(String question);
	public String generateAnswerWithPromptTemplateAndFile(String question);
	
	public String generateUserAndSystemAnswer(String question);
}
