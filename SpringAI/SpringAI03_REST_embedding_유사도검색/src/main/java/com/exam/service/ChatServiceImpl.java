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
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    ChatClient chatClient;  
	
    EmbeddingModel embeddingModel;
    
    public ChatServiceImpl(ChatClient.Builder chatClientBuilder, EmbeddingModel embeddingModel) {
        this.chatClient = chatClientBuilder
        			     .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
        				 .build();
        
        this.embeddingModel = embeddingModel;
    }

	@Override
	public float[] generateEmbed(String question) {
		
		return embeddingModel.embed(question);
	}


	@Override
	public double generateEmbed2(String question1, String question2) {
		
		List<float[]> response =  embeddingModel.embed(List.of(question1, question2));
	
		double n = cosineSimilarity(response.get(0), response.get(1));
		
		return n;
	}
	// ChatGPT에 요청한 코드임. ( Cosine 유사도 방법으로 2개의 float [] 타입으로 전달받는 메서드 형태로 알려줘.)
	private double cosineSimilarity(float[] vectorA, float[] vectorB) {
		
		if (vectorA.length != vectorB.length) {
			throw new IllegalArgumentException("Vectors must be of the same length");
		}

		// Initialize variables for dot product and magnitudes
		double dotProduct = 0.0;
		double magnitudeA = 0.0;
		double magnitudeB = 0.0;

		// Calculate dot product and magnitudes
		for (int i = 0; i < vectorA.length; i++) {
			dotProduct += vectorA[i] * vectorB[i];
			magnitudeA += vectorA[i] * vectorA[i];
			magnitudeB += vectorB[i] * vectorB[i];
		}

		// Calculate and return cosine similarity
		return dotProduct / (Math.sqrt(magnitudeA) * Math.sqrt(magnitudeB));
	}

}
