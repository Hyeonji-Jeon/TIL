package com.exam;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class SpringAiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringAiApplication.class, args);
	}

	
	// https://docs.spring.io/spring-ai/reference/1.0/api/chatclient.html#_creating_a_chatclient 참조
	ChatClient chatClient;
	 
	public SpringAiApplication(ChatClient.Builder builder) {
		this.chatClient = builder
				//이전 프롬프트 기억시키기
			    .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
			    .build();
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("LOGGER: ChatClient:{} ", chatClient);
		
		String response = chatClient.prompt("자바개발자가 알아야될 스킬은 뭐야").call().content();							
	    log.info("LOGGER: response:{} ", response);
	}	
}
	
