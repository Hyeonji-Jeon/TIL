package com.exam.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.model.Media;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.ImageService;

@RestController
public class ImageController {


	ImageService imgService;
	
	public ImageController(ImageService imgService) {
		this.imgService = imgService;
	}

	@GetMapping("/ai/image-to-text")
	public String describeImage() {
		
//		return  imgService.describeLocalImage1();
		return  imgService.describeLocalImage2();
//		return  imgService.describeLocalImage3();
	}
	
	

}
