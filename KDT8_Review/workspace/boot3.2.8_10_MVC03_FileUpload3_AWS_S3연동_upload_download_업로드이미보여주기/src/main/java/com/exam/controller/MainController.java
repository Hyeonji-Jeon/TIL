package com.exam.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.exam.dto.UploadDTO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	AmazonS3 s3Client;
	String bucketName;
	
	public MainController(AmazonS3 s3Client, @Value("${aws.s3.bucket}")
	String bucketName) {
		this.s3Client =s3Client;
		this.bucketName = bucketName;
	}
	
	@GetMapping("/upload")
	public String main() {
		
		logger.info("logger:{}", "MainController.main()");
		
		return "uploadForm";  
	}
	
	@PostMapping("/upload")
	public String upload(UploadDTO dto, Model m) {
		
		String theText = dto.getTheText();
		MultipartFile theFile = dto.getTheFile();
		
		long size = theFile.getSize();
		String name = theFile.getName();
		String originalFilename  = theFile.getOriginalFilename();
		String contentType  = theFile.getContentType();
		
		// AWS S3에 저장 
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType(contentType);
		metadata.setContentLength(size);
		
		InputStream inputStream=null;
		String key = "images/" +  originalFilename;  // file 경로 및 파일명
		try {
			inputStream = theFile.getInputStream();
//			s3Client.putObject(new PutObjectRequest(bucketName, originalFilename, inputStream, metadata));
			s3Client.putObject(bucketName, key, inputStream, metadata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Tomcat 서버에 저장 
//		File f = new File("C://upload", originalFilename);
//		try {
//			theFile.transferTo(f);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
				
				
		// MySQL DB에 저장
		
		
		// 업로드한 이미지 랜더링 위한 S3객체 URL 모델에 저장
		String url = "https://s3.ap-northeast-2.amazonaws.com/"+bucketName+"/"+key;
		m.addAttribute("url", url);
		
		// 다운로드 위한 key 모델에 저장
		m.addAttribute("key", key);
		
		return "uploadInfo";
	}
	
	@GetMapping("/download")
	public @ResponseBody void download(@RequestParam String key, HttpServletResponse response) throws Exception {
		
		S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, key));
		InputStream is = s3Object.getObjectContent();
		
		String fileName = key.split("/")[1];
		
		byte b[] = new byte[4096];

		String sMimeType = s3Object.getObjectMetadata().getContentType();

		if(sMimeType == null) sMimeType = "application/octet-stream";

		response.setContentType(sMimeType);

		String sEncoding = new String(fileName.getBytes("UTF-8"),"8859_1");

		response.setHeader("Content-Disposition", "attachment; filename= " + sEncoding);
		
		ServletOutputStream out = response.getOutputStream();
		int numRead;

		while((numRead = is.read(b, 0, b.length)) != -1) {
			out.write(b, 0, numRead);
		}
		out.flush(); 
		out.close();
		is.close();
	}
	
}
