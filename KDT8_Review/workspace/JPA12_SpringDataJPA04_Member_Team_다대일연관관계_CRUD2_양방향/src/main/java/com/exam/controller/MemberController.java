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

	MemberService studentService;
	
	public MemberController(MemberService studentService) {
		this.studentService = studentService;
	}

	/*
	    요청 응답
	    
		
	*/
	@GetMapping("/members")
	public ResponseEntity<List<MemberDTO>> findAll(){
		List<MemberDTO> studentDTOList = studentService.findAll();
		return ResponseEntity.ok().body(studentDTOList);
	}
	
	/*
	   	{
		   "id": 20007,
			"username": "홍길동",
			"team":{
				"id": 90003,
				"name": "L123890"
			}
		}
	*/
	@PostMapping("/members")
	public ResponseEntity<MemberDTO> addStudent(@RequestBody MemberDTO memberDTO ){

		studentService.addMember(memberDTO);
		return ResponseEntity.created(null).body(memberDTO);
	}
	
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Void> deleteMember(@PathVariable Long id){
		studentService.deleteMember(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/teams/{id}")
	public ResponseEntity<Void> deleteTeam(@PathVariable Long id){
		studentService.deleteTeam(id);
		return ResponseEntity.noContent().build();	// 204
	}
	
	
	/*
	 20007
   	{
		"username": "이순신"

	}
*/
	@PutMapping("/members/{id}")
	public ResponseEntity<MemberDTO> updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO ){
		studentService.updateMember(id, memberDTO);
		return ResponseEntity.status(201).body(memberDTO);
	}
}
