package com.exam.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class EmpDTO {


	Long empno;
	String ename;
	String job;
	Long mgr;
	
	LocalDate hiredate;
	Long sal;
	Long comm;
	Long deptno;

}
