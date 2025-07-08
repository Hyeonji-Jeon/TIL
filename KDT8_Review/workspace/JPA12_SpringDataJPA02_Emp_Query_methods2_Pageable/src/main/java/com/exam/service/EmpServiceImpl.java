package com.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exam.dto.EmpDTO;
import com.exam.entity.Emp;
import com.exam.repository.EmpRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpRepository repository;
	
	// 전체 emp 레코드 조회
	@Override
	public Page<Emp> getAllEmployees(Pageable pageable) {
		return repository.findAll(pageable);
	}
	

	@Override
	public Page<Emp> getAllEmployeesByJob(String job, Pageable pageable) {
		return repository.findByJob(job, pageable);
	}


	

	
	
	//유틸리티 메서드
	public Emp fromEmpDTOToEmp(EmpDTO dto) {
		System.out.println("EmpDTO >>>>>>>>>>>>>>>>>>>>>>>" + dto);
		Emp entity = Emp.builder()
                .empno(dto.getEmpno())
                .ename(dto.getEname())
                .sal(dto.getSal())
                 .build();
		System.out.println("Emp >>>>>>>>>>>>>>>>>>>>>>>" + entity);
		return entity;
	}
	public EmpDTO fromEmpToEmpDTO(Emp entity) {
		EmpDTO dto = EmpDTO.builder()
                .empno(entity.getEmpno())
                .ename(entity.getEname())
                .job(entity.getJob())
                .mgr(entity.getMgr())
                .hiredate(entity.getHiredate())
                .comm(entity.getComm())
                .sal(entity.getSal())
                .build();
		return dto;
	}
	private List<EmpDTO> fromEmpListToEmpDTOList(List<Emp> entity) {
		List<EmpDTO> list = 
				entity.stream().map( emp -> EmpDTO.builder()
						                   .empno(emp.getEmpno())
						                   .ename(emp.getEname())
						                   .job(emp.getJob())
						                   .mgr(emp.getMgr())
						                   .hiredate(emp.getHiredate())
						                   .comm(emp.getComm())
						                   .sal(emp.getSal())
						                    .build()
						                    ).collect(Collectors.toList());
		
		return list;
	}

	private List<Emp> fromEmpDTOListToEmpList(List<EmpDTO> dto) {
		List<Emp> list = 
				dto.stream().map( x -> Emp.builder()
						                   .empno(x.getEmpno())
						                   .ename(x.getEname())
						                   .sal(x.getSal())
						                    .build()
						                    ).collect(Collectors.toList());
		
		return list;
	}

}
