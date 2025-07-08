package com.exam.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.exam.dto.UploadDTO;

@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/upload")
	public String main() {
		
		logger.info("logger:{}", "MainController.main()");
		
		return "uploadForm";  
	}
	
	@PostMapping("/upload")
	public String upload(UploadDTO dto) {
		
		String theText = dto.getTheText();
		MultipartFile theFile = dto.getTheFile();
		
		long size = theFile.getSize();
		String name = theFile.getName();
		String originalFilename  = theFile.getOriginalFilename();
		String contentType  = theFile.getContentType();
		System.out.println("size: " +size);
		System.out.println("name: " +name);
		System.out.println("originalFilename: " +originalFilename);
		System.out.println("contentType: " +contentType);
		
		//저장 디레고리
		File f = new File("C://upload", originalFilename);
		
		try {
			theFile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "uploadInfo";
	}

}
