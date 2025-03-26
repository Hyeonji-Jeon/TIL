package org.zerock.reply.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.board.dto.PageRequestDTO;
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
	
	@GetMapping("{rno}")
	public ResponseEntity<ReplyDTO> get(@PathVariable("rno") Integer rno ){
		
		return ResponseEntity.ok(service.getOne(rno));
	}
	
	
	@GetMapping("{bno}/list")
	public ResponseEntity<PageResponseDTO<ReplyDTO>> listByBno(
			@PathVariable("bno")Integer bno,
			PageRequestDTO pageRequest,
			@RequestParam(name="last", defaultValue = "false") boolean last) {
		
		
		return ResponseEntity.ok(service.list(bno, pageRequest, last));
	}
	
	@PutMapping("{rno}")
	public ResponseEntity<Map<String, String>> modify(
			@PathVariable("rno") Integer rno,
			@RequestBody ReplyDTO replyDTO  ){
		
		replyDTO.setRno(rno);
		service.modify(replyDTO, false);
		
		return ResponseEntity.ok(Map.of("result","success"));
		
	}
	
	@DeleteMapping("{rno}")
	public ResponseEntity<Map<String, String>> remove(@PathVariable("rno") Integer rno) {
		
		ReplyDTO dto = ReplyDTO.builder().rno(rno).build();
		
		service.modify(dto, true);
		
		return ResponseEntity.ok(Map.of("result","success"));
		
	}
	
}









