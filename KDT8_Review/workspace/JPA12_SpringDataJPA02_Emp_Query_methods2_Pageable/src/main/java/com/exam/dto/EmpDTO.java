package com.exam.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmpDTO {

	private Long empno;
	
	private String ename;
	private String job;
	private Long mgr;
	private LocalDate hiredate;
	private Long sal;
	private Long comm;

	

	public EmpDTO(Long empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}

}
