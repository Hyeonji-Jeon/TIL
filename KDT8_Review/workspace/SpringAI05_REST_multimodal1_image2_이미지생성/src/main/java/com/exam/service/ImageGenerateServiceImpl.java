package com.exam.service;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.model.Media;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


@Service
public class ImageGenerateServiceImpl implements ImageGenerateService {

	ChatClient chatClient;
	ImageModel imageModel;
	//OpenAiImageModel openAiImageModel;
	
	public ImageGenerateServiceImpl(ImageModel imageModel, ChatClient.Builder builder) {
		this.imageModel = imageModel;
		this.chatClient = builder.build();
	}

	@Override
	public String generateImage(String question) {

		// https://docs.spring.io/spring-ai/reference/1.0/api/image/openai-image.html#image-options 소스코드 참조
		// https://docs.spring.io/spring-ai/reference/1.0/api/image/openai-image.html#_configuration_properties
		// https://platform.openai.com/docs/api-reference/images/create   응답은 url로 반환
		ImageResponse response = imageModel.call(
		        new ImagePrompt(question,
		        OpenAiImageOptions.builder()
		                .withN(1)    // 이미지 갯수. 1 ~ 10 사이 지정,  DALL-E-3는 1개만 지원됨.  유료는 여러개 지정 가능.
		                .withHeight(1024)
		                .withWidth(1024)
		                .withQuality("hd")
		                .build()
		        		));
		
		return response.getResult().getOutput().getUrl();   // 응답은 url로 반환
	}

}
