package com.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.service.ImageGenerateService;


@RestController
public class ImageGenerateController {


	ImageGenerateService imgService;
	
	public ImageGenerateController(ImageGenerateService imgService) {
		this.imgService = imgService;
	}
	/*
	Talend API
	
	요청:
	 Content-Type: text/plain
	 
	Body: text,file,form 중에서 text 선택 
    
          두카티 타고 있는 이순신 장군 만들어줘

*/
	@PostMapping("/ai/text-to-image")
	public String generateImage(@RequestBody String question) {
		
		return  imgService.generateImage(question);
	}

}
