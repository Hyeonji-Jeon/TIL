package com.exam.service;


import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.model.Media;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;


@Service
public class AudioUploadServiceImpl implements AudioUploadService {

OpenAiAudioTranscriptionModel transcriptionModel;
	
	
	public AudioUploadServiceImpl(OpenAiAudioTranscriptionModel transcriptionModel) {
		this.transcriptionModel = transcriptionModel;
	}


	public String describeUploadAudio(String prompt, String path) {

	        //https://docs.spring.io/spring-ai/reference/1.0/api/audio/transcriptions/openai-transcriptions.html 소스코드 참조
			OpenAiAudioApi.TranscriptResponseFormat responseFormat = OpenAiAudioApi.TranscriptResponseFormat.SRT; // JSON, VTT( '시간범위: 문장' 포맷 )

			// OpenAiAudioTranscriptionOptions 는 옵션임. 지정하지 않아도 됨.
			OpenAiAudioTranscriptionOptions transcriptionOptions = OpenAiAudioTranscriptionOptions.builder()
			    .language("ko")
			    .temperature(0.5f)   // 다양성과 창의성을 조절하는 매개변수.  값이 높을수록 더 창의적임.
			    .responseFormat(responseFormat)
			    .build();
			
			
			
			AudioTranscriptionPrompt transcriptionRequest = 
					new AudioTranscriptionPrompt(new FileSystemResource(path));
//				AudioTranscriptionPrompt transcriptionRequest = new AudioTranscriptionPrompt(new ClassPathResource("/audio/안녕하세요좋은아침입니다.mp3"), transcriptionOptions);
			AudioTranscriptionResponse response = transcriptionModel.call(transcriptionRequest);
		
				
		   return response.getResult().getOutput();
	}


}
