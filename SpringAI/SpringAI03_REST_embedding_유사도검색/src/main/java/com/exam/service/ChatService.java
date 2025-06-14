package com.exam.service;

import org.springframework.ai.chat.model.ChatResponse;

public interface ChatService {

	public float[] generateEmbed(String question);
	public double generateEmbed2(String question1, String question2);
}
