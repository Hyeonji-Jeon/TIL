package com.exam.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exam.dto.UploadDTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	

	@PostMapping("/upload")
	public String upload(UploadDTO dto) {
		
		
		MultipartFile theFile = dto.getTheFile();
		String theText = dto.getTheText();
		
		//byte[] byte_arr = theFile.getBytes();
		String contentType =theFile.getContentType();
		String name = theFile.getName();
		String originalFilename
		      = theFile.getOriginalFilename();
		long size = theFile.getSize();
		
		logger.info("LOGGER:contentType: {}", contentType);
		logger.info("LOGGER:name: {}", name);
		logger.info("LOGGER:originalFilename: {}", originalFilename);
		logger.info("LOGGER:size: {}", size);
		
		// 저장할 경로 설정
		File f = new File("c:\\upload", originalFilename);
		
		// 파일 저장
		try {
			theFile.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "uploadInfo";  //나중에 PRG 패턴으로 변경
	}
}






