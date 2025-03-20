package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("list")
	public void list( @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model) {
		
		log.info(requestDTO);
		
		model.addAttribute("res", boardService.list(requestDTO));
		
	}
	
	@GetMapping("add")
	public void addGET() {
		
	}
	
	@PostMapping("add")
	public String addPOST(BoardDTO dto, RedirectAttributes rttr) {
		
		log.info("--------------");
		
		log.info(dto);
		
		rttr.addAttribute("name", "홍길동");
		
		rttr.addFlashAttribute("result", 111);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("ex1")
	public String ex1( @RequestParam(name = "age", defaultValue = "10") int age ) {
		
		log.info("ex1 " + age);
		
		return "redirect:/board/list";
	}
	
	
}
