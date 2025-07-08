package com.exam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.dto.MemberDTO;
import com.exam.service.AuthenticationService;
import com.exam.service.MemberService;

import jakarta.validation.Valid;

@Controller
public class MemberController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	MemberService memberService;
	
	AuthenticationService authService;
	
	public MemberController(MemberService memberService, AuthenticationService authService ) {
		this.memberService = memberService;
		this.authService = authService;
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
		String encodedPW = new BCryptPasswordEncoder().encode(pw);
		
		logger.info("LOGGER: pw: {}" , pw);
		logger.info("LOGGER: encodedPW: {}" , encodedPW);
		
		dto.setPasswd(encodedPW);
		
		// 회원저장
		int n = memberService.save(dto);
		// 성공
		return "redirect:home";
	}
	
	//mypage
	 @GetMapping("/mypage")
	 public String mypage(Model m) {
		 
		 // AuthProvider 에서 저장시킨 Authentication 이 필요하다.
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	
		 logger.info("LOGGER: mypage의 Authentication: {}" , auth);
		 /*	
		    UsernamePasswordAuthenticationToken [Principal=MemberDTO [userid=a, passwd=1234, username=홍길동], 
		                                         Credentials=[PROTECTED], 
		                                         Authenticated=true, 
		                                         Details=WebAuthenticationDetails 
		                                         [RemoteIpAddress=0:0:0:0:0:0:0:1, 
		                                         SessionId=B4DD7D0D7B4E3DD5E210557BC3779F5F], 
		                                         Granted Authorities=[USER]]
		 
		 */
		 MemberDTO dto = (MemberDTO)auth.getPrincipal();
		 String userid = dto.getUserid();
		 
		 
		 MemberDTO db_dto = authService.findByUserid(userid);
		 
		 m.addAttribute("mypage", db_dto);
		 
		 return "mypage";
	 }
	
	
	
	
	
	
	
	
	
	
}



