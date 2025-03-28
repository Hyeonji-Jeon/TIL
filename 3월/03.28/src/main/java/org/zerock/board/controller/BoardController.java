package org.zerock.board.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.service.BoardService;
import org.zerock.member.dto.MemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

//스프링의 빈으로 동작하기 위한 설정 
@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor 
public class BoardController {


	private final BoardService boardService;
	
	@GetMapping("read/{bno}")
	public String read( 
			@PathVariable("bno") Integer bno, 
			@ModelAttribute("requestDTO") PageRequestDTO requestDTO, 
			@AuthenticationPrincipal MemberDTO memberDTO,
			Model model ) {
		
		log.info("bno: " + bno);
		log.info("memberDTO: " + memberDTO);
		
		
		model.addAttribute("board", boardService.getOne(bno));
		
		return "board/read";
	}



	@GetMapping("list")
	public void list( 
			@ModelAttribute("requestDTO") PageRequestDTO requestDTO,  
			Model model) { //마지막 파라미터로 //카트역할 View까지 데이터를 전달
		
		log.info(requestDTO);
		
		log.info("-------------------------------");
		
		log.info(boardService.getClass().getName());
		
		
		
		model.addAttribute("res", boardService.list(requestDTO));
		
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("add")
	public void addGET() {
		
	}
	
	//dto.writer 와 현재 사용자의 mid가 같아야만 허용 
	@PreAuthorize("authentication.principal.mid == #dto.writer")
	@PostMapping("add")
	public String addPOST(BoardDTO dto, RedirectAttributes rttr) {
		
		log.info("-------------");
		
		log.info(dto);

		Integer newBno = boardService.add(dto);

		
		//1회용 파라미터를 전달 주소창에 안 보이지만 전달은 됨 
		rttr.addFlashAttribute("result", newBno);
		
		
		return "redirect:/board/list";
	}
	
	//board/ex1
	@GetMapping("ex1")
	public String ex1 ( @RequestParam(name = "age", defaultValue = "10") int age) {
		
		log.info("ex1 " + age);
		
		return "redirect:/board/list";
	}
	

}






