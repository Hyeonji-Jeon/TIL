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

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController  // @Controller + @ResponseBody
@Slf4j
public class UserController {

	UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}



	@PostMapping("/rest/users")
	public ResponseEntity<UserDTO> save2(@RequestBody UserDTO dto) {
		ResponseEntity<UserDTO> entity = ResponseEntity.created(null).body(dto); // 201 상태코드 
		return entity;
	}
	
	@PostMapping("/rest/users2")
	public ResponseEntity<UserDTO> save3(@Valid  @RequestBody UserDTO dto) {  // SOAP 방식의 BindingResult 필요없음. 대신 ExceptionHandler가 처리함.
		ResponseEntity<UserDTO> entity = ResponseEntity.created(null).body(dto); // 201 상태코드 
		return entity;
	}
	
	//  GET  http://localhost:8090/app/rest/users
	@GetMapping("/rest/users")
	public List<UserDTO> findAll(){
		return service.findAll();
	}
	
}










