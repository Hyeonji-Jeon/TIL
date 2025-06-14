package com.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.exam.dto.FootBallPlayer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    ChatClient chatClient;  
	
	public ChatServiceImpl(ChatClient.Builder builder) {
		chatClient = builder
				    .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
				    .build();
    }

	@Override
	public FootBallPlayer generateAnswerWithEntity(String question) {
		
	
		
		String prompt_message = """
				    
                    요청:  {x} 선수에 대한 이름을 포함해서 경력 목록을 만들어줘.

				""";
		
		PromptTemplate template = new PromptTemplate(prompt_message);
		Prompt prompt = template.create(Map.of("x", question));

		FootBallPlayer response = chatClient.prompt(prompt)
				          .call()
				          .entity(FootBallPlayer.class);
		
		return response;
	}

	@Override
	public List<FootBallPlayer> generateAnswerWithEntity2(String question) {
		String prompt_message = """
			    
                  전 세계 {x} 선수에 대한 이름을 포함해서 경력 목록을 만들어줘.
                  단, 2025년 현재 가장 유명한 선수 위주로 알려줘 

			""";
	
		PromptTemplate template = new PromptTemplate(prompt_message);
		Prompt prompt = template.create(Map.of("x", question));
	
		List<FootBallPlayer> response = chatClient.prompt(prompt)
			          .call()
			          .entity(new ParameterizedTypeReference<List<FootBallPlayer>>() {});
	
	  return response;
	}

}
