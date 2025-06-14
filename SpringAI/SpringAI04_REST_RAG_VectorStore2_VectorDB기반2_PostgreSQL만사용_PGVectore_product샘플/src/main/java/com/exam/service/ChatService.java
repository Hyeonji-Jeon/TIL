package com.exam.service;

import java.util.List;

import org.springframework.ai.chat.model.ChatResponse;

import com.exam.dto.ProductDTO;

public interface ChatService {

	
	public void product_addAll(List<ProductDTO> list);
	public void product_add(ProductDTO dto);
	
	public String generateAnswerWithVectorStoreSimilaritySearchString(String question);
}
