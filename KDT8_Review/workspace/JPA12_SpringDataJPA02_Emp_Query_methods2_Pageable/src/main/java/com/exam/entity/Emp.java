package com.exam.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Emp {

	@Id
//	@GeneratedValue
	private Long empno;
	
	private String ename;
	private String job;
	private Long mgr;
	private LocalDate hiredate;
	private Long sal;
	private Long comm;


	
	@ManyToOne(optional = true, fetch = FetchType.EAGER)  // Lazy면 에러 발생됨.
	@JoinColumn(name = "deptno")
	private Dept dept;
	
}
