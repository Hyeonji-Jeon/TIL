package com.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exam.dto.EmpDTO;
import com.exam.entity.Emp;
import com.exam.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	EmpRepository empRepository;
	
	
	public EmpServiceImpl(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public List<EmpDTO> findByEname(String ename) {
		List<Emp> empList = empRepository.findByEname(ename);
		
		List<EmpDTO> empDTOList = empList.stream().map(e-> {
														    EmpDTO dto = EmpDTO.builder()
														    		     .empno(e.getEmpno())
														    		     .ename(e.getEname())
														    		     .job(e.getJob())
														    		     .mgr(e.getMgr())
														    		     .hiredate(e.getHiredate())
														    		     .sal(e.getSal())
														    		     .comm(e.getComm())
														    		     .deptno(e.getDeptno())
														    			 .build();
														    return dto;
		                                              }).collect(Collectors.toList());
		
		return empDTOList;
	}

	@Override
	public List<EmpDTO> findByEnameOrSal(String ename, Long sal) {
		List<Emp> empList = empRepository.findByEnameOrSal(ename, sal);
		List<EmpDTO> empDTOList = empList.stream().map(e-> {
		    EmpDTO dto = EmpDTO.builder()
		    		     .empno(e.getEmpno())
		    		     .ename(e.getEname())
		    		     .job(e.getJob())
		    		     .mgr(e.getMgr())
		    		     .hiredate(e.getHiredate())
		    		     .sal(e.getSal())
		    		     .comm(e.getComm())
		    		     .deptno(e.getDeptno())
		    			 .build();
		    return dto;
      }).collect(Collectors.toList());

return empDTOList;
	}

	@Override
	public List<EmpDTO> findBySalLessThan(Long sal) {
		List<Emp> empList = empRepository.findBySalLessThan(sal);
		List<EmpDTO> empDTOList = empList.stream().map(e-> {
		    EmpDTO dto = EmpDTO.builder()
		    		     .empno(e.getEmpno())
		    		     .ename(e.getEname())
		    		     .job(e.getJob())
		    		     .mgr(e.getMgr())
		    		     .hiredate(e.getHiredate())
		    		     .sal(e.getSal())
		    		     .comm(e.getComm())
		    		     .deptno(e.getDeptno())
		    			 .build();
		    return dto;
      }).collect(Collectors.toList());

return empDTOList;
	}

	@Override
	public List<EmpDTO> findByEnameContaining(String ename) {
		List<Emp> empList = empRepository.findByEnameContaining(ename);
		List<EmpDTO> empDTOList = empList.stream().map(e-> {
		    EmpDTO dto = EmpDTO.builder()
		    		     .empno(e.getEmpno())
		    		     .ename(e.getEname())
		    		     .job(e.getJob())
		    		     .mgr(e.getMgr())
		    		     .hiredate(e.getHiredate())
		    		     .sal(e.getSal())
		    		     .comm(e.getComm())
		    		     .deptno(e.getDeptno())
		    			 .build();
		    return dto;
      }).collect(Collectors.toList());

return empDTOList;
	}

	@Override
	public List<EmpDTO> findByCommIsNull() {
		List<Emp> empList = empRepository.findByCommIsNull();
		List<EmpDTO> empDTOList = empList.stream().map(e-> {
		    EmpDTO dto = EmpDTO.builder()
		    		     .empno(e.getEmpno())
		    		     .ename(e.getEname())
		    		     .job(e.getJob())
		    		     .mgr(e.getMgr())
		    		     .hiredate(e.getHiredate())
		    		     .sal(e.getSal())
		    		     .comm(e.getComm())
		    		     .deptno(e.getDeptno())
		    			 .build();
		    return dto;
      }).collect(Collectors.toList());

return empDTOList;
	}

}
