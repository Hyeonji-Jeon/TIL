package com.exam.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;


@Service
public class ChatServiceImpl implements ChatService {

    ChatClient chatClient;  
    
    // TextVectorLoader 에서 반환된 VectorStore 주입 받음.
    // 주입받은 VectorStore 는 전역 또는 지역 방식으로 사용이 가능함.
	VectorStore vectorStore;
	
	public ChatServiceImpl(ChatClient.Builder builder, VectorStore vectorStore) {
		this.chatClient = builder
				    .defaultAdvisors( new MessageChatMemoryAdvisor(new InMemoryChatMemory())
				    		         ,new QuestionAnswerAdvisor(vectorStore)
				    		         ) // 전역 VectorStore
				    .build();
	
		this.vectorStore = vectorStore;
    }

	@Override
	public String generateAnswerWithVectorStore(String question) {
		
		return chatClient.prompt()
//				 .advisors(new QuestionAnswerAdvisor(vectorStore, SearchRequest.builder().topK(5).build()))   // 지역 VectorStore
//				 .advisors(new QuestionAnswerAdvisor(vectorStore))   // 지역 VectorStore
				 .user(question)
		         .call()
		         .content();
	}
}
