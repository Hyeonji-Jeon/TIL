package com.exam.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.model.Media;
import org.springframework.core.io.ClassPathResource;
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


	public String describeLocalImage1() {

		var imageResource = new ClassPathResource("images/NewYork.jpg");

		var userMessage = new UserMessage(
			"이 그림에 대해서 설명해줘", // content
			new Media(MimeTypeUtils.IMAGE_JPEG, imageResource),
			new Media(MimeTypeUtils.IMAGE_PNG, imageResource)); 
		
		ChatResponse response = chatModel.call(new Prompt(userMessage));
				          
		return response.getResult().getOutput().getText();
	}

	public String describeLocalImage2() {
		
		// https://docs.spring.io/spring-ai/reference/1.0/api/multimodality.html 소스코드 참조
		var imageResource = new ClassPathResource("images/pusan_haeundae.jpg");
		
		String response = chatClient.prompt()
				.user(u -> u.text("이 그림에 대해서 설명해줘")
						    .media(MimeTypeUtils.IMAGE_JPEG, imageResource)
						    .media(MimeTypeUtils.IMAGE_PNG, imageResource)
						    )
				.call()
				.content();
		
		return response;
	}
	
	public String describeLocalImage3() {
		
		// https://docs.spring.io/spring-ai/reference/1.0/api/multimodality.html 소스코드 참조
		var imageResource = new ClassPathResource("images/NewYork.jpg");
		var imageResource2 = new ClassPathResource("images/pusan_haeundae.jpg");
		
		String response = chatClient.prompt()
				.user(u -> u.text("이 그림에 대해서 설명해줘")
							//멀티도 가능
						    .media(MimeTypeUtils.IMAGE_JPEG, imageResource)
						    .media(MimeTypeUtils.IMAGE_JPEG, imageResource2)						    
					  )
				.call()
				.content();
		
		return response;
	}
}
