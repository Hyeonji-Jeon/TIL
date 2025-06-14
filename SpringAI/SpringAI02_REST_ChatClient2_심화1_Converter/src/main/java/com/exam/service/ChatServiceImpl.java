package com.exam.service;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
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
	public FootBallPlayer generateAnswerWithBeanConverter(String question) {
		
		//BeanOutputConverter 는 JSON 포맷으로 반환
		BeanOutputConverter<FootBallPlayer> converter = 
				new BeanOutputConverter<>(new ParameterizedTypeReference<FootBallPlayer>() {});
		
		
		String prompt_message = """
				    
                    요청:  {x} 선수에 대한 이름을 포함해서 경력 목록을 만들어줘.
                    
				    응답:{format}
				""";
		
		PromptTemplate template = new PromptTemplate(prompt_message);
		Prompt prompt = template.create(Map.of("x", question,
				          "format", converter.getFormat()));
		/*
		   converter.getFormat() 실제 구현 코드는 다음과 같다.
		   
		    	@Override
				public String getFormat() {
					String template = """
							Your response should be in JSON format.
							Do not include any explanations, only provide a RFC8259 compliant JSON response following this format without deviation.
							Do not include markdown code blocks in your response.
							Remove the ```json markdown from the output.
							Here is the JSON Schema instance your output must adhere to:
							```%s```
							""";
					return String.format(template, this.jsonSchema);
				}
		 */
		
		String response = chatClient.prompt(prompt)
				          .call().content();
		
		FootBallPlayer bean = converter.convert(response);
		return bean;
	}

	@Override
	public List<FootBallPlayer> generateAnswerWithBeanConverter2(String question) {
		
		//BeanOutputConverter 는 JSON 포맷으로 반환
		BeanOutputConverter<List<FootBallPlayer>> converter = 
				new BeanOutputConverter<>(new ParameterizedTypeReference<List<FootBallPlayer>>() {});
		
		
		String prompt_message = """
			    
                요청: 전 세계 {x} 선수에 대한 이름을 포함해서 경력 목록을 만들어줘.
                
			    응답: {format}
			""";
	
		PromptTemplate template = new PromptTemplate(prompt_message);
		Prompt prompt = template.create(Map.of("x", question,
				          "format", converter.getFormat()));
		String response = chatClient.prompt(prompt)
		                            .call().content();
		
		List<FootBallPlayer> listPlayer =converter.convert(response);
		
	   return listPlayer;
	}

	@Override
	public List<String> generateAnswerWithListConverter(String question) {
		
		//ListOutputConverter 는 ,(comma separate)으로 반환
		ListOutputConverter converter = 
				new ListOutputConverter(new DefaultConversionService());
		
		String prompt_message = """
			    
                요청: 전 세계 {x} 선수중  상위 5에 속하는 이름 알려줘
                
			    응답: {format}
			""";
	
		PromptTemplate template = new PromptTemplate(prompt_message);
		Prompt prompt = template.create(Map.of("x", question,
				          "format", converter.getFormat()));
		String response = chatClient.prompt(prompt)
		                            .call().content();
		
		List<String> listPlayer =converter.convert(response);
		return listPlayer;
	}

	@Override
	public Map<String, Object> generateAnswerWithMapConverter(String question) {
		
		MapOutputConverter converter = new MapOutputConverter();
		
		String prompt_message = """
			    
                요청: 전 세계 {x} 선수중  상위 5에 속하는 이름과 주요정보 알려줘
                
			    응답: {format}
			""";
	
		PromptTemplate template = new PromptTemplate(prompt_message);
		Prompt prompt = template.create(Map.of("x", question,
				          "format", converter.getFormat()));
		String response = chatClient.prompt(prompt)
		                            .call().content();
		
		Map<String, Object> map =converter.convert(response);
		return map;
	}
}
