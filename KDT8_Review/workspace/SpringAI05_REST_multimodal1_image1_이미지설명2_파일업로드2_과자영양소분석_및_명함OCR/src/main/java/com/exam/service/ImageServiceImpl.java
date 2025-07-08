package com.exam.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.model.Media;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


@Service
public class ImageServiceImpl implements ImageService {

	ChatModel chatModel;
	ChatClient chatClient;
	ImageModel imageModel;
	//OpenAiImageModel openAiImageModel;
	
	public ImageServiceImpl(ChatModel chatModel, ImageModel imageModel, ChatClient.Builder builder) {
		this.chatModel = chatModel;
		this.imageModel = imageModel;
		this.chatClient = builder.build();
	}


	public String describeUploadImage(String prompt, String path) {

		String response = chatClient.prompt()
				.user(u -> u.text(prompt).media(MimeTypeUtils.IMAGE_JPEG,new FileSystemResource(path))
						                 .media(MimeTypeUtils.IMAGE_PNG,new FileSystemResource(path)))
				.call()
				.content();
				          
		return response;
	}

}
