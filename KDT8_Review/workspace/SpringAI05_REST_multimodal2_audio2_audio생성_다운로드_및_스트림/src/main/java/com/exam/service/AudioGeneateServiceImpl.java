package com.exam.service;


import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;


@Service
public class AudioGeneateServiceImpl implements AudioGenerateService {

	OpenAiAudioSpeechModel openAiAudioSpeechModel;
	
	public AudioGeneateServiceImpl(OpenAiAudioSpeechModel openAiAudioSpeechModel) {
		this.openAiAudioSpeechModel = openAiAudioSpeechModel;
	}


	public byte [] generateAudio(String content) {

		byte [] responseAsBytes = openAiAudioSpeechModel.call(content);
		return responseAsBytes;
	}

	public byte [] generateAudio2(String content) {

		    OpenAiAudioSpeechOptions speechOptions = OpenAiAudioSpeechOptions.builder()
			    .model("tts-1")
			    .voice(OpenAiAudioApi.SpeechRequest.Voice.ALLOY)  // 다양한 목소리 지원 ( alloy, echo, fable, onyx, nova, shimmer )
			    .responseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3) // opus, flac, wav, pcm
			    .speed(1.0f)
			    .build();

			SpeechPrompt speechPrompt = new SpeechPrompt(content, speechOptions);
			SpeechResponse response = openAiAudioSpeechModel.call(speechPrompt);
			
			
			
		byte [] responseAsBytes = response.getResult().getOutput();
		return responseAsBytes;
	}
}
