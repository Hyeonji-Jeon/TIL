package com.exam.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.LoginDTO;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@GetMapping("/set7")
	public ModelAndView set() {  
	
		ModelAndView mav = new ModelAndView();
		// 모델 저장
		mav.addObject("userid", "홍길동" );
		mav.addObject("passwd", "1234" );
	
		// 뷰 저장 (JSP)
		mav.setViewName("main");
		return mav;
	}
	
	@GetMapping("/set6")
	public String set6(@ModelAttribute("xxx") ArrayList<LoginDTO> list) {  
	
		list.add(new LoginDTO("홍길동1", "1234"));
		list.add(new LoginDTO("홍길동2", "9999"));
		
		// 내부적으로 다음과 같다.
		// Model m = new Model();
		// m.addAttribute("loginDTOList", list)); //저장되는 key는 기본적으로 loginDTOList명으로 설정됨.
		// m.addAttribute("xxx", list)); //저장되는 key를 명시적으로 설정가능. @ModelAttribute("xxx") 이용
		
		return "main3";
	}
	
	
	@GetMapping("/set5")			  //(key)	//모델
	public String set5(@ModelAttribute("xxx")   LoginDTO dto) {  
	
		//m.addAttribute("dto", new LoginDTO("홍길동", "1234"));
		dto.setUserid("홍길동4");
		dto.setPasswd("12345");
		
		// 내부적으로 다음과 같다.
		// Model m = new Model();
		// m.addAttribute("loginDTO", dto)); //저장되는 key는 기본적으로 DTO명으로 설정됨.
		// m.addAttribute("xxx", dto)); //저장되는 key를 명시적으로 설정가능. @ModelAttribute("xxx") 이용
		
		return "main2";
	}
	
//	@GetMapping("/set4")
//	public String set4(Model m) {  
//	
//		m.addAttribute("dto", new LoginDTO("홍길동", "1234"));
//	
//		return "main2";
//	}
	
	
	@GetMapping("/set3")
	public String set3(Map<String, String> m) {   // 내부적으로 객체생성됨.
	
		m.put("userid", "홍길동" );
		m.put("passwd", "1234" );
	
		return "main";
	}
	
	@GetMapping("/set2")
	public String set2(Model m) { // 내부적으로 객체생성됨.
	
		m.addAttribute("userid", "홍길동" );
		m.addAttribute("passwd", 1234 );
		
		return "main";
	}
	
	
	@GetMapping("/set1")
	public String set1(HttpServletRequest request) {
							//모델
							//(key, value)
		request.setAttribute("userid", "홍길동" );
		request.setAttribute("passwd", 1234 );
		
		return "main";
	}
	
	

}






