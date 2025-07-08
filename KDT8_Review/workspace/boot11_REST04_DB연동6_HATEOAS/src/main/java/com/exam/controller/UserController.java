package com.exam.controller;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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


	
	
		
	//  GET  http://localhost:8090/app/rest/users
	@GetMapping("/rest/users")
	public List<UserDTO> findAll(){
		return service.findAll();
	}

	
	//2. HATEOAS 설정
	@GetMapping("/rest/users/{id}")
	public EntityModel<UserDTO> findById(@PathVariable Long id) {
		
		UserDTO dto  =service.findById(id);
		
		// 요청에 해당되는 UserDTO 저장 역할
		EntityModel<UserDTO> entityModel = EntityModel.of(dto);
		
		// 추가링크 설정
		// 전체 사용자 조회
		WebMvcLinkBuilder link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
		
		// 요청한 id 다음 사용자 조회
		WebMvcLinkBuilder link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findById(id+10));
		
		// 요청한 id 이전 사용자 조회
		WebMvcLinkBuilder link3 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findById(id-10));
		
		
		// 생성된 링크를 최종적으로 EntityModel 저장
		entityModel.add(link1.withRel("findAll"));  // 저장된 링크에 대한 key값 설정
		entityModel.add(link2.withRel("next_user"));  // 저장된 링크에 대한 key값 설정
		entityModel.add(link3.withRel("prev_user"));  // 저장된 링크에 대한 key값 설정
		
		return entityModel;
	}

}










