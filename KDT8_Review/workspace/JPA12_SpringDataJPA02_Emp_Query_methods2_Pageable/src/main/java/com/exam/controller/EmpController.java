package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Emp;
import com.exam.service.EmpService;



@RestController
public class EmpController {

	@Autowired
	EmpService service;
	
	// http://localhost:8090/app/emp?page=0&size=5&sort=empno,asc
	@GetMapping("/emp")
    public Page<Emp> getAllEmp(Pageable pageable) {
        return service.getAllEmployees(pageable);
    }
	
	// http://localhost:8090/app/empjob?job=SALESMAN&page=0&size=2&sort=empno,asc
		@GetMapping("/empjob")
	    public Page<Emp> getAllEmployees(@RequestParam String job,Pageable pageable) {
	        return service.getAllEmployeesByJob(job, pageable);
	    }
}




