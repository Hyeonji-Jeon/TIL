package com.exam.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;


@Service
public class ChatServiceImpl implements ChatService {

    ChatClient chatClient;  
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
	public String generateAnswerWithVectorStoreSimilaritySearch(String question) {
		
		String prompt_message  ="""

			    질문:
			    {x}
			
			    응답:
			    {documents}
			 
			""";
		
		 PromptTemplate template = new PromptTemplate(prompt_message);
	     
	     Map<String, Object> promptParams = new HashMap<>();
	     promptParams.put("x", question);
	     promptParams.put("documents", findSimilarData(question));
		
	     return chatClient
		    		.prompt(template.create(promptParams))
		    		.call()
		    		.content();

	}
	
	// https://docs.spring.io/spring-ai/reference/1.0/api/vectordbs/pgvector.html#_metadata_filtering 
			public String findSimilarData(String q) {
				
			  List<Document>  documents	= vectorStore.similaritySearch(SearchRequest.builder().query(q).topK(5).build());
			  
			  return documents.stream()
					  .map(document -> document.getFormattedContent())
					  .collect(Collectors.joining());
			}
	
}
