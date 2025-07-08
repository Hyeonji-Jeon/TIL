package com.exam.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;

@Controller
@SessionAttributes(value = {"login"}) // Model에 "login" 키를 사용하면 HttpSession에 저장됨.
public class LoginController {

	
	MemberService memberService;
	
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/loginForm") 
	public String main() {
		
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map,  Model m) {
		
		MemberDTO dto = memberService.login(map);
		
		if(dto!=null) {
		  //정상 로그인	
		  m.addAttribute("login", dto);
		  return "redirect:main";
		}
		
		//실패하면
		m.addAttribute("errorMessage", "아이디와 비번 다시 확인하시오");
		return "loginForm";  // loginForm.jsp
		
	}
	
	//로그아웃
	// 로그인이후의 작업이기 때문에 로그인 여부를 확인해야 된다.
	// 이 작업을 HandlerInterceptor 이용해서 할 생각임.
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		
		// @SessionAttributes 를 사용한 세션을 cleanup 시킴
		status.setComplete();
		
		return "redirect:main";
	}
	
}




