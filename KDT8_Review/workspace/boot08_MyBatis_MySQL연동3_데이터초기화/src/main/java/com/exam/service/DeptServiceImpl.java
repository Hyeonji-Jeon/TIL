package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.config.DeptMapper;
import com.exam.dto.DeptDTO;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	DeptMapper mapper;

	public DeptServiceImpl(DeptMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<DeptDTO> findAll() {
		return mapper.findAll();
	}

	@Override
	@Transactional  // dao의 save 메서드가 실행되어 성공하면 자동으로 commit 됨. 생략 가능
	public int save(DeptDTO dto) {
		int n = mapper.save(dto);
		return n;
	}

	@Override
	@Transactional // dao의 update 메서드가 실행되어 성공하면 자동으로 commit 됨. 생략 가능
	public int update(DeptDTO dto) {
		int n = mapper.update(dto);
		return n;
	}

	@Override
	@Transactional // dao의 delete 메서드가 실행되어 성공하면 자동으로 commit 됨. 생략 가능
	public int delete(int deptno) {
		int n = mapper.delete(deptno);
		return n;
	}
	
	
	
	
	
	
}
