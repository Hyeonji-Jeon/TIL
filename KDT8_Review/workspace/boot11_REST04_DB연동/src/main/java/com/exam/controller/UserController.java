package com.exam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

	// GET  http://localhost:8090/app/rest/users/10
	//  존재하지 않는 값 요청시 404 에러가 아닌 200 반환됨. ==>  나중에 404로 변경할 예정임.
	@GetMapping("/rest/users/{id}")
	public UserDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	// GET  http://localhost:8090/app/rest/users/10/guswl1397
	@GetMapping("/rest/users/{id}/{email}")
	public UserDTO findById(@PathVariable Long id, @PathVariable String email) {
		return service.findById(id);
	}
	
	//POST ( 저장 )
	/*
	    추가로 실제 저장할 데이터 지정: { "id":40, "username":"강감찬", "birthdate":"2025-12-21"}
		추가로 header 정보 설정:  Content-type: application/json
		
		저장이 성공하면 200 반환됨.  ==> 나중에 201 ( created 상태값 ) 로 변경할 예정임.
	 */

	@PostMapping("/rest/users")
	public void save(@RequestBody UserDTO dto) {
		int n = service.save(dto);
	}
	
	// PUT ( 수정 )
	/*
	   where 절에 필요한 id는 PathVariable로 전달하고
	   수정할 데이터인 username 과 birthdate 는 {"username":"강감찬2", "birthdate":"2025-12-21"} 전달한다.
	   추가로 header 정보 설정:  Content-type: application/json
	*/
	@PutMapping("/rest/users/{id}")
	public void update(@PathVariable Long id, @RequestBody UserDTO dto) {
		dto.setId(id);
		int n = service.update(dto);
	}
	
	// DELETE ( 삭제 )
	@DeleteMapping("/rest/users/{id}")
	public void delete(@PathVariable Long id) {
		int n = service.delete(id);
	}
}










