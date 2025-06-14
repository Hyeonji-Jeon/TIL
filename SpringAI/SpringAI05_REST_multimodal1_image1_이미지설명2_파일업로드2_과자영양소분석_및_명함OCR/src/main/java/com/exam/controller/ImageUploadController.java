package com.exam.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exam.service.ImageService;

@RestController
public class ImageUploadController {


	ImageService imgService;
	
	public ImageUploadController(ImageService imgService) {
		this.imgService = imgService;
	}
	/*
	Talend API
	
	요청:
	 Content-Type: multipart/form-data
	 
	Body: text,file,form 중에서 form 선택 >  add a parameter
	
	name: prompt
	타입: Text
	값: 과자 영양소  표로 만들어줘
	
	name: file
	타입: File
	값: Choose a file... 버튼 클릭해서 이미지 선택  
	    예> 과장열량4.jpg



*/
	@PostMapping("/ai/upload/image-to-text")
	public String describeUploadImage(String prompt,
			                          @RequestParam("file") MultipartFile file) {
		
	 	  String response = "";
				
		  if (file.isEmpty()) {
	            return "파일을 지정해야 됩니다.";
	        }
		 
		  try {
			  
	            Path uploadDir = Paths.get("c:\\upload");
	            if (Files.notExists(uploadDir)) {
	                Files.createDirectories(uploadDir); 
	            }

	            Path path = uploadDir.resolve(file.getOriginalFilename());
	            Files.write(path, file.getBytes(), StandardOpenOption.CREATE);
	            
	            response =imgService.describeUploadImage(prompt,path.toString());
	          

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  
		return  response;
	}
	
	

}
