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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exam.dto.UserDTO;
import com.exam.exception.UserNotFoundException;
import com.exam.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController  // @Controller + @ResponseBody
@Slf4j
@RequestMapping("/swagger")
public class UserSwaggerController {

	UserService service;
	
	public UserSwaggerController(UserService service) {
		this.service = service;
	}

	//POST ( 저장 )
	/*
	    추가로 실제 저장할 데이터 지정: { "id":40, "username":"강감찬", birthdate:"2025-12-21"}
		추가로 header 정보 설정:  Content-type: application/json
		
		저장이 성공하면 200 반환됨.  ==> 나중에 201 ( created 상태값 ) 로 변경할 예정임.
	 */

	@Operation(
			    summary = "UserDTO 이용해서 user 생성",
			     description = "user 생성"
				)
	@PostMapping("/rest/users1")
	public void save(@RequestBody UserDTO dto) {
		int n = service.save(dto);
	}
	
	// POST 요청에 대한 응답처리 개선1 - 201 status code설정
	@PostMapping("/rest/users2")
	public ResponseEntity<UserDTO> save2(@RequestBody UserDTO dto) {
		//int n = service.save(dto);
		ResponseEntity<UserDTO> entity = ResponseEntity.created(null).build(); // 201 상태코드 
//		entity = ResponseEntity.badRequest().build();   // 400 상태코드
//		entity = ResponseEntity.notFound().build();   // 400 상태코드
//		entity = ResponseEntity.noContent().build();   // 204 상태코드
//		entity = ResponseEntity.internalServerError().build();   // 500 상태코드
		// 메서드가 제공되지 않는 경우는 status(상태값) 이용
//		entity = ResponseEntity.status(401).build();   // 401 상태코드
		return entity;
	}
	
	@PostMapping("/rest/users")
	public ResponseEntity<UserDTO> save3(@Valid  @RequestBody UserDTO dto) {  // SOAP 방식의 BindingResult 필요없음. 대신 ExceptionHandler가 처리함.
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
	    @Operation(
		    summary = "id 용해서 user 조회",
		     description = "user 조회"
			)
	    @Parameters({@Parameter(name = "id", description = "User의 pk값", required = true)})
		@GetMapping("/rest/users/{id}")
		public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
			
			UserDTO dto = service.findById(id);
			if(dto == null) throw new UserNotFoundException(id+ " 에 해당하는 데이터가 없음.");
			
			return ResponseEntity.status(200).body(dto);
		}
	
	

	// PUT ( 수정 )
	/*
	   where 절에 필요한 id는 PathVariable로 전달하고
	   수정할 데이터인 username 과 birthdate 는 {"username":"강감찬2", birthdate:"2025-12-21"} 전달한다.
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










