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
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import com.exam.dto.ProductDTO;
import com.exam.entity.Product;
import com.exam.repository.ChatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class ChatServiceImpl implements ChatService {

	private final ChatRepository chatRepository;
	VectorStore vectorStore;
	ChatClient chatClient;  
	
	public ChatServiceImpl(ChatRepository chatRepository, VectorStore vectorStore, ChatClient.Builder builder) {
		  this.chatRepository = chatRepository;
		  this.vectorStore = vectorStore;
		  this.chatClient = builder
				    .defaultAdvisors( new MessageChatMemoryAdvisor(new InMemoryChatMemory())
				    		         ,new QuestionAnswerAdvisor(vectorStore)
				    		         ) // 전역 VectorStore
				    .build();
    }

	@Override
	public void product_addAll(List<ProductDTO> list) {
		
		for (ProductDTO dto : list) {
			
			// Postgres RDB 에 저장
			Product product = Product.builder()
					  .id(dto.getId())
				      .name(dto.getName())
				      .description(dto.getDescription())
				      .build();
	
			chatRepository.save(product);
			
			// PGVector Database에 저장
			String content = dto.getName()+" " + dto.getDescription();
			Document doc = new Document(content);
			
			TokenTextSplitter textSplitter = new TokenTextSplitter(); // 기본 옵션 사용
			List<Document> docs = textSplitter.apply(List.of(doc)); // Document 리스트에 적용
			
			vectorStore.add(docs);
		}
		
	}
	
	@Override
	public void product_add(ProductDTO dto){
		
		// RDB 저장
		Product product = Product.builder()
				          .id(dto.getId())
					      .name(dto.getName())
					      .description(dto.getDescription())
					      .build();

		chatRepository.save(product);
		
		// vector 저장
		 String content = dto.getName()+" " + dto.getDescription();
	     Document doc = new Document(content);

         TokenTextSplitter textSplitter = new TokenTextSplitter(); // 기본 옵션 사용
         List<Document> docs = textSplitter.apply(List.of(doc)); // Document 리스트에 적용

         vectorStore.add(docs);
		
	}
	@Override
public String generateAnswerWithVectorStoreSimilaritySearchString(String question) {
		
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
		
	     String content =  chatClient
		    		.prompt(template.create(promptParams))
		    		.call()
		    		.content();

	     return content;
	}
	
	
	// https://docs.spring.io/spring-ai/reference/1.0/api/vectordbs/pgvector.html#_metadata_filtering 
		public String findSimilarData(String q) {
			
		  List<Document>  documents	= vectorStore.similaritySearch(SearchRequest.builder().query(q).topK(5).build());
		  
		  return documents.stream()
				  .map(document -> document.getFormattedContent())
				  .collect(Collectors.joining());
		}

		/////////////////////////////////////////////////////////////////////////////////////////
	
}
