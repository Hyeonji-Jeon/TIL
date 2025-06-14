package com.exam.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exam.service.AudioService;

@RestController
public class AudioController {


	AudioService audioService;
	
	public AudioController(AudioService audioService) {
		this.audioService = audioService;
	}

	@GetMapping("/ai/audio-to-text")
	public String describeAudio() {
		
		return  audioService.describeAudio();
	}
	
	

}
