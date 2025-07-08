package com.exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.UserDTO;
import com.exam.dto.UserDTO2;
import com.exam.dto.UserDTO3;

import lombok.extern.slf4j.Slf4j;

@RestController  // @Controller + @ResponseBody
@Slf4j
public class MainController {

	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	// http://localhost:8090/app/hello
	@GetMapping("/hello")
	public String hello() {
		
		UserDTO dto = new UserDTO();  // @NoArgsConstructor
		
		// @Setter
		dto.setUsername("이순신");
		dto.setAge(44);
		dto.setAddress("전라");
		
		
		// @Getter
		String username = dto.getUsername();
		int age = dto.getAge();
		String address = dto.getAddress();
		
	//	logger.info("LOGGER: username: {}", username);
		
		log.info("LOGGER: username: {}", username);
		
		UserDTO dto2 = new UserDTO("홍길동", 10, "서울"); // @AllArgsConstructor
		log.info("LOGGER: UserDTO: {}", dto2);   // @ToString
		
		return "Hello World:GET";
	}
	
	@GetMapping("/builder")
	public UserDTO2 builder() {
		
		// UserDTO2 생성해서  홍길동 20 서울  정보를 저장하자.
		// 1. 생성자 이용
		// 2. setter 메서드 이용
		// 3. 빌더 패턴 (*************************)
		
		UserDTO2 dto = UserDTO2.builder()
					           .username("홍길동")
					           .age(20)
					           //.address("서울")
				               .build();
		
		log.info("LOGGER: username: {}", dto.getUsername());
		log.info("LOGGER: age: {}", dto.getAge());
		log.info("LOGGER: address: {}", dto.getAddress());
		
		
		return dto;
	}
	@GetMapping("/builder2")
	public UserDTO3 builder2() {
		
		// UserDTO2 생성해서  홍길동 20 서울  정보를 저장하자.
		// 1. 생성자 이용
		// 2. setter 메서드 이용
		// 3. 빌더 패턴 (*************************)
		
		UserDTO3 dto = UserDTO3.builder()
					           .username("홍길동")
					           .age(20)
//					           .address("서울")
				               .build();
		
		log.info("LOGGER: username: {}", dto.getUsername());
		log.info("LOGGER: age: {}", dto.getAge());
		log.info("LOGGER: address: {}", dto.getAddress());
		
		
		return dto;
	}
	
}










