package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dao.DeptDAO;
import com.exam.dto.DeptDTO;

@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService {

	DeptDAO dao;

	public DeptServiceImpl(DeptDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<DeptDTO> findAll() {
		return dao.findAll();
	}

	@Override
	//@Transactional  // dao의 save 메서드가 실행되어 성공하면 자동으로 commit 됨. 생략 가능
	public int save(DeptDTO dto) {
		int n = dao.save(dto);
		return n;
	}

	@Override
	//@Transactional // dao의 update 메서드가 실행되어 성공하면 자동으로 commit 됨. 생략 가능
	public int update(DeptDTO dto) {
		int n = dao.update(dto);
		return n;
	}

	@Override
	//@Transactional // dao의 delete 메서드가 실행되어 성공하면 자동으로 commit 됨. 생략 가능
	public int delete(int deptno) {
		int n = dao.delete(deptno);
		return n;
	}

	@Override
	//@Transactional // 성공하면 모두 자동으로 commit 되고 하나라도 실패하면 모두 자동으로 rollback 됨
	public int tx(DeptDTO dto, int deptno) {
		
		int n = dao.delete(deptno);
		int n2 = dao.save(dto); // 에러발생시킴
		
		return n+n2;
	}

	
	
	
}
