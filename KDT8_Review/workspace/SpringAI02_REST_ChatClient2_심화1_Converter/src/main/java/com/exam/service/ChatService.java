package com.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;

import com.exam.dto.FootBallPlayer;

public interface ChatService {

	public FootBallPlayer generateAnswerWithBeanConverter(String question);
	public List<FootBallPlayer> generateAnswerWithBeanConverter2(String question);
	
	public List<String> generateAnswerWithListConverter(String question);
	
	public Map<String, Object> generateAnswerWithMapConverter(String question);
	

}
