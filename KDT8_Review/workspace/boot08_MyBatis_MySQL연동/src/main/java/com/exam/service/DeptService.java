package com.exam.service;

import java.util.List;

import com.exam.dto.DeptDTO;

public interface DeptService {
	public List<DeptDTO> findAll();
	public int save(DeptDTO dto);
	public int update(DeptDTO dto);
	public int delete ( int deptno);
	
	//트랜잭션 처리
	public int tx(DeptDTO dto, int deptno);
}
