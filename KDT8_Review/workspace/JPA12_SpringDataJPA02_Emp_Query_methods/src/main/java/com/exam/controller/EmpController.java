package com.exam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.EmpDTO;
import com.exam.exception.UserNotFoundException;
import com.exam.service.EmpService;

@RestController
public class EmpController {

	EmpService empService;
	
	public EmpController(EmpService empService) {
		this.empService = empService;
	}


   // http://localhost:8090/app/emps/SMITH
	@GetMapping("/emps/{ename}")
	public ResponseEntity<List<EmpDTO>> findByEname(@PathVariable String ename){
		List<EmpDTO> empList = empService.findByEname(ename);
		if(empList.size() == 0) throw new UserNotFoundException(ename + " 에 해당하는 데이터가 없음.");
		return ResponseEntity.status(200).body(empList);
	}
	
	// http://localhost:8090/app/emps2/SMITH/1600
	@GetMapping("/emps2/{ename}/{sal}")
	public ResponseEntity<List<EmpDTO>> findByEnameOrSal(@PathVariable String ename, @PathVariable Long sal){
		List<EmpDTO> empList = empService.findByEnameOrSal(ename, sal);
		return ResponseEntity.status(200).body(empList);
	}
	
	// http://localhost:8090/app/emps3/1600
	@GetMapping("/emps3/{sal}")
	public ResponseEntity<List<EmpDTO>> findBySalLessThan( @PathVariable Long sal){
		List<EmpDTO> empList = empService.findBySalLessThan( sal);
		return ResponseEntity.status(200).body(empList);
	}
	
	// http://localhost:8090/app/emps4/A
	@GetMapping("/emps4/{ename}")
	public ResponseEntity<List<EmpDTO>> findByEnameContaining( @PathVariable String ename){
		List<EmpDTO> empList = empService.findByEnameContaining( ename);
		return ResponseEntity.status(200).body(empList);
	}
	
	//http://localhost:8090/app/emps5
	@GetMapping("/emps5")
	public ResponseEntity<List<EmpDTO>> findByCommIsNull(){
		List<EmpDTO> empList = empService.findByCommIsNull();
		return ResponseEntity.status(200).body(empList);
	}
}








