package com.exam.config;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


/*
     역할은 다음과 같다.
     
      job_list.txt 파일 내용을 읽어서 임베딩 처리하여 job_list_vector_store.json 파일에 저장하고
      이 벡터 데이터를 참조할 수 있는 VectorStore 타입을 반환함.
      나중에 Service 에서 VectorStore 를 주입 받아서 데이터 검색시 유사도 검색으로 처리함.
  
 */

@Configuration
public class TextVectorLoader {

	@Value("classpath:/job_list.txt")
	Resource textResource;
	
	
	@Bean
	SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel) {
		
		SimpleVectorStore vectorStore = SimpleVectorStore.builder(embeddingModel).build();
		
		File vectorStoreFile= new File(".//src//main//resources//job_list_vector_store.json");
		
		if(vectorStoreFile.exists()) {
			System.out.println("Loaded Vector Store File!");
			vectorStore.load(vectorStoreFile);
			
		}else {
			System.out.println("Creating Vector Store");
			
			TextReader reader = new TextReader(textResource);
			
			TokenTextSplitter textSplitter = new TokenTextSplitter();
//			new TokenTextSplitter(chunkSize, minChunkSize, minChunkLength, MaxNumchunks, keepSeparator)
			List<Document> docs = textSplitter.apply(reader.get());   // split 메서드와 동일기능
			
			vectorStore.add(docs);
			vectorStore.save(vectorStoreFile);
			
			System.out.println("Vector Store Created Success");
			
		}//end if~else
		
		return vectorStore;
	}	
}
