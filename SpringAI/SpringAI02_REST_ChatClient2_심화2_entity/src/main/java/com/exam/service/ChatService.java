package com.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;

import com.exam.dto.FootBallPlayer;

public interface ChatService {

	public FootBallPlayer generateAnswerWithEntity(String question);
	public List<FootBallPlayer> generateAnswerWithEntity2(String question);
	

}
