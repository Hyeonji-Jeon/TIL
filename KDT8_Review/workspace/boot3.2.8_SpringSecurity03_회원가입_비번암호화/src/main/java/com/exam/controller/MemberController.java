package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;

import jakarta.validation.Valid;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	//회원가입
	@GetMapping("/signup")
	public String signupForm(Model m) {
		
		MemberDTO dto = new MemberDTO();
		m.addAttribute("mem", dto);
		
		return "memberForm";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid @ModelAttribute("mem")
	                      MemberDTO dto, BindingResult result) {
		
		// 에러발생
		if(result.hasErrors()) {
			return "memberForm";
		}
		
		logger.info("LOGGER: dto: {}" , dto);

		//비번 암호화 (필수*******************************)
		String pw = dto.getPasswd(); //암호화 안된 pw: 1234
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String encodedPW = passwordEncoder.encode(pw);
		
		logger.info("LOGGER: pw: {}" , pw);
		logger.info("LOGGER: encodedPW: {}" , encodedPW);
		
		dto.setPasswd(encodedPW);
		
		// raw 비번(1234) 암호 비번(asdfasdfsfafasf) 비교
		boolean result2 = passwordEncoder.matches(pw, encodedPW);
		logger.info("LOGGER: result2: {}" , result2 );
		
		
		// 회원저장
		int n = memberService.save(dto);
		// 성공
		return "redirect:home";
	}
}



