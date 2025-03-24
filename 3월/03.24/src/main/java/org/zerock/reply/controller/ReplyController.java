package org.zerock.reply.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.reply.dto.ReplyDTO;
import org.zerock.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyService service;

	@PostMapping("")
	public ResponseEntity<PageResponseDTO<ReplyDTO>> addReply(@RequestBody ReplyDTO replyDTO){
		
		log.info(replyDTO);
		
		//201 //200
		return ResponseEntity.ok(service.addReply(replyDTO));
		
	}
}






