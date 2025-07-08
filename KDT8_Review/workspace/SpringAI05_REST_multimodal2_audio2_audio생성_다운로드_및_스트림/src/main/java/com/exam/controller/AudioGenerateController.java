package com.exam.controller;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exam.service.AudioGenerateService;


@RestController
public class AudioGenerateController {


	AudioGenerateService audioService;
	
	public AudioGenerateController(AudioGenerateService audioService) {
		this.audioService = audioService;
	}

	// http://localhost:8090/app/ai/text-to-audio?content="안녕하세요.피카츄입니다."
	@GetMapping("/ai/text-to-audio")
	public ResponseEntity<Resource> generateAudio(@RequestParam String content) {
		
		byte [] responseAsBytes = audioService.generateAudio(content);
		
		// 다운로드 처리
		ByteArrayResource byteArrayResource = new ByteArrayResource(responseAsBytes);
	
		 return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(byteArrayResource.contentLength())
				.header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename("output.mp3").build().toString())
				.body(byteArrayResource);
 	}
	
	// http://localhost:8090/app/ai/text-to-audio2?content="감사합니다.고맙습니다"
	@GetMapping("/ai/text-to-audio2")
	public ResponseEntity<byte[]> generateAudio2(@RequestParam String content) {
		
		// 스트리밍 오디오 
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, "audio/mpeg");
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=output2.mp3");
				
		byte [] responseAsBytes = audioService.generateAudio(content);
		
		// 스트리밍 처리
	
		return new ResponseEntity<byte[]>(responseAsBytes, headers, HttpStatus.OK);
 	}

}
