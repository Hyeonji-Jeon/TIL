package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.dto.MemberDTO;

import jakarta.validation.Valid;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// 화면이 필요한 요청
	// 항상 @GetMapping --> @PostMapping 이고
	// 요청매핑값은 동일해야 함
	
	@GetMapping("/member")		// 이거 ("/member") 랑
	public String memberForm(Model m) {
		
		//DTO를 Model에 저장 필수
		MemberDTO dto = new MemberDTO();
		m.addAttribute("xxx", dto);
		
		return "memberForm";
	}

	@PostMapping("/member")		// 이거 ("/member") 같아야 됨
	public String member(@Valid  @ModelAttribute("xxx") MemberDTO dto,
			              BindingResult result) {
		
		if(result.hasErrors()) {
			return "memberForm";
		}
		
		// 성공시 코드 작성
		
		return "main";
	}
	
}





