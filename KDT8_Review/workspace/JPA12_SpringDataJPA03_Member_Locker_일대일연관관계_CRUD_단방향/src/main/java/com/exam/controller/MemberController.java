package com.exam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MemberController {

	MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	/*
	    요청 응답
	    
	    [
			{
			  "id": 20001,
			  "username": "Ranga",
			  "locker":{
				  "id": 40001,
				  "name": "E123456"
				}
			},
		
	*/
	@GetMapping("/members")
	public ResponseEntity<List<MemberDTO>> findAll(){
		List<MemberDTO> memberDTOList = memberService.findAll();
		return ResponseEntity.ok().body(memberDTOList);
	}
	
	/*
	  locker 테이블에는 40004,A123890 레코드가 있음.
	  만약 없으면 참조무결설 에러 발생됨.
	 
	   	{
		    
		    "id":20004,
			"username": "홍길동",
			"locker":{
				"id": 40004,
				"name": "A123890"
			}
		}
	*/
	@PostMapping("/members")
	public ResponseEntity<MemberDTO> addStudent(@RequestBody MemberDTO memberDTO ){
		memberService.addMember(memberDTO);
		return ResponseEntity.created(null).body(memberDTO);
	}
	
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
		memberService.deleteMember(id);
		return ResponseEntity.noContent().build(); // 204
	}
	
	/*
	20004
   	{
		"username": "이순신",
	
	}
*/
	
	@PutMapping("/members/{id}")
	public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody MemberDTO memberDTO ){
		memberService.updateMember(id, memberDTO);
		return ResponseEntity.status(201).body(null);
	}
}
