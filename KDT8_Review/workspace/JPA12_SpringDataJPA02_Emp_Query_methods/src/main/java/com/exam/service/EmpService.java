package com.exam.service;

import java.util.List;

import com.exam.dto.EmpDTO;


public interface EmpService {
	List<EmpDTO> findByEname(String ename);
	List<EmpDTO> findByEnameOrSal(String ename, Long sal);
	List<EmpDTO> findBySalLessThan(Long sal);
	List<EmpDTO> findByEnameContaining(String ename);
	List<EmpDTO> findByCommIsNull();
}
