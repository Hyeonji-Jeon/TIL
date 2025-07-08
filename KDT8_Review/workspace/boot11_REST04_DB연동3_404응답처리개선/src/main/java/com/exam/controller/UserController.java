package com.exam.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exam.dto.UserDTO;
import com.exam.exception.UserNotFoundException;
import com.exam.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController  // @Controller + @ResponseBody
@Slf4j
public class UserController {

	UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	//  GET  http://localhost:8090/app/rest/users
	@GetMapping("/rest/users")
	public List<UserDTO> findAll(){
		return service.findAll();
	}

	// GET  http://localhost:8090/app/rest/users/10
	//  존재하지 않는 값 요청시 404 에러가 아닌 200 반환됨. ==>  나중에 404로 변경할 예정임.
	@GetMapping("/rest/users99/{id}")
	public UserDTO findById99(@PathVariable Long id) {
		return service.findById(id);
	}
	
	// 404 에 대한 개선1 - ResponseEntity.notFound().build() 이용
	@GetMapping("/rest/users98/{id}")
	public ResponseEntity<UserDTO> findById98(@PathVariable Long id) {
		
		UserDTO dto = service.findById(id);
		if(dto != null) {
			
			return ResponseEntity.status(200).build();
			
		}else {
			
//			return ResponseEntity.status(404).build();
			return ResponseEntity.notFound().build();
		}
	}
	
	// 404 에 대한 개선2 - 사용자 예외 클래스 이용
		@GetMapping("/rest/users97/{id}")
		public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
			
			UserDTO dto = service.findById(id);
			if(dto == null) throw new UserNotFoundException(id+ " 에 해당하는 데이터가 없음.");
			
			return ResponseEntity.status(200).body(dto);
		}
}










