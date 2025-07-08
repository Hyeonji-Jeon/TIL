package com.exam.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	public String generateAnswer(String question) {
		return chatClient.prompt(question)
				        .call()
				        .content();
	}

	@Override
	public String generateAnswerWithOptions(String question) {
		
		//ChatOptions 설정
		OpenAiChatOptions options = new OpenAiChatOptions();
		
		options.setModel("gpt-4o-mini");
		options.setTemperature(0.7); // 값이 높을수록 상상력이 더 풍부해짐.
		options.setMaxTokens(20);
		
		Prompt prompt = new Prompt(question, options);
		
		/*
		  application.properties 설정과 동일
		  spring.ai.openai.chat.options.model=gpt-4o-mini
          spring.ai.openai.chat.options.temperature=0.7F
          spring.ai.azure.openai.chat.options.max-tokens=20
		*/
		
		String response = chatClient.prompt(prompt).call().content();
		return response;
	}
	
	
	@Override
	public String generateAnswerWithPromptTemplate(String question) {
		String prompt_template = """
			    
				   {x} 의 업적에 대하여 표로 알려줘.
			
				""";
		PromptTemplate template = new PromptTemplate(prompt_template);
		Prompt prompt = template.create(Map.of("x", question));
		
		return chatClient.prompt(prompt)
		                 .call()
		                 .content();
	}
	
	// 프롬프트를 외부파일로 작성하기
	@Value("classpath:/prompts/system-message.st")
	org.springframework.core.io.Resource systemResource;
	
	@Override
	public String generateAnswerWithPromptTemplateAndFile(String question) {
		
		PromptTemplate template = new PromptTemplate(systemResource);
		Prompt prompt = template.create(Map.of("x", question));
		
		return chatClient.prompt(prompt)
		                 .call()
		                 .content();
	}

	@Override
	public String generateUserAndSystemAnswer(String question) {
		

		String systemText  = """
			    
				   만일 요청된 스포츠에 관하여 잘 모르면 그냥 모른다고 응답해줘.
			
				""";
		
		String userText  = """
				    
				   %s 규칙에 대해서 알려줘.
			
				""";
	
		/*
			UserMessage userMessage = new UserMessage(String.format(userText, question));
			SystemMessage systemMessage = new SystemMessage(systemText);
			Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
			return chatClient.prompt(prompt).call().content();
		*/
		return chatClient.prompt()
//				 .system(systemText)
				 .user(String.format(userText, question))
		         .call()
		         .content();
	}


}
