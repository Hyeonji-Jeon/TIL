package com.exam.config;


import java.io.File;
import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.TextReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;


@Configuration
@Slf4j
public class PGVectorLoader {

	@Value("classpath:/job_list.txt")
	Resource textResource;
	
	VectorStore vectorStore;
	
	JdbcClient jdbcClient;

	public PGVectorLoader(VectorStore vectorStore, JdbcClient jdbcClient) {
		this.vectorStore = vectorStore;
		this.jdbcClient = jdbcClient;
	}
	
	@PostConstruct
	public void init() {
		
		Integer count = jdbcClient.sql("select count(*) from vector_store")
								   .query(Integer.class)
								   .single();
		
		log.info("ChromaDB count: {} " , count );
		
		if(count == 0) {
			
			System.out.println("Creating Vector Store");
			
			
			TextReader reader = new TextReader(textResource);
			
			TokenTextSplitter textSplitter = new TokenTextSplitter();
//			new TokenTextSplitter(chunkSize, minChunkSize, minChunkLength, MaxNumchunks, keepSeparator)
			List<Document> docs = textSplitter.apply(reader.get());   // split 메서드와 동일기능
			vectorStore.add(docs);
			
			log.info("Application is Started and Ready to Serve"  );
		}
		
	}
	
}
