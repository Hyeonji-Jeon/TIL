package com.exam.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.dto.MemberDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Controller
@Validated
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@GetMapping("/member")
	public String memberForm() {
		return "memberForm";
	}

	@PostMapping("/member")
	public String member(@NotBlank(message = "userid 필수")
	                     @RequestParam String userid,
	                     
	                     @RequestParam String passwd,
	                     
	                     @Size(max = 4, message = "최대 4글자")
	                     @RequestParam String username,
	                     
	                     @RequestParam String phone,
	                     
	                     @NotNull (message = "targetDate 필수")
	                 	 @FutureOrPresent(message = "현재 또는 미래날짜만 가능")
	                     @RequestParam LocalDate targetDate
				         ) {
		// 성공시 코드 작성
		logger.info("LOGGER:userid: {}" , userid);
		logger.info("LOGGER:passwd: {}" , passwd);
		logger.info("LOGGER:username: {}" , username);
		logger.info("LOGGER:phone: {}" , phone);
		logger.info("LOGGER:targetDate: {}" , targetDate);
		return "main";
	}
	
}





