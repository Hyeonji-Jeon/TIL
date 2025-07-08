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
import com.exam.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController  // @Controller + @ResponseBody
@Slf4j
public class UserController {

	UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	//POST ( 저장 )
	/*
	    추가로 실제 저장할 데이터 지정: { "id":40, "username":"강감찬", "birthdate":"2025-12-21"}
		추가로 header 정보 설정:  Content-type: application/json
		
		저장이 성공하면 200 반환됨.  ==> 나중에 201 ( created 상태값 ) 로 변경할 예정임.
	 */

	@PostMapping("/rest/users1")
	public void save(@RequestBody UserDTO dto) {
		int n = service.save(dto);
	}
	
	// POST 요청에 대한 응답처리 개선1 - 201 status code설정
	@PostMapping("/rest/users2")
	public ResponseEntity<UserDTO> save2(@RequestBody UserDTO dto) {
		//int n = service.save(dto);
		ResponseEntity<UserDTO> entity = ResponseEntity.created(null).build(); // 201 상태코드 
		entity = ResponseEntity.badRequest().build();   // 400 상태코드
//		entity = ResponseEntity.noContent().build();   // 204 상태코드
//		entity = ResponseEntity.internalServerError().build();   // 500 상태코드
		// 메서드가 제공되지 않는 경우는 status(상태값) 이용
//		entity = ResponseEntity.status(401).build();   // 401 상태코드
		return entity;
	}
	
	@PostMapping("/rest/users3")
	public ResponseEntity<UserDTO> save3(@RequestBody UserDTO dto) {
		int n = service.save(dto);
		
		// http://localhost:8090/app/rest/users/60
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()  // http://localhost:8090/app/rest/users/
												  .path("/{id}")
												  .buildAndExpand(dto.getId())
												  .toUri();
		
		ResponseEntity<UserDTO> entity = ResponseEntity.created(location).build(); // 201 상태코드 와  location 추가

		return entity;
	}
	
	
	//  GET  http://localhost:8090/app/rest/users
	@GetMapping("/rest/users")
	public List<UserDTO> findAll(){
		return service.findAll();
	}

}










