package com.exam.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exam.entity.Emp;


public interface EmpService {


	public Page<Emp> getAllEmployees(Pageable pageable);
	public Page<Emp> getAllEmployeesByJob(String job, Pageable pageable);
}
