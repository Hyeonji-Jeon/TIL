package com.exam.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.dto.DeptDTO;

@Repository
public class DeptDAO {

	SqlSessionTemplate session;

	public DeptDAO(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public List<DeptDTO> findAll(){
		List<DeptDTO> list = session.selectList("com.exam.config.DeptMapper.findAll");
		return list;
	}
	
	// auto commit
	public int save(DeptDTO dto) {
		int n = session.insert("com.exam.config.DeptMapper.save", dto);
		return n;
	}
	
	public int update(DeptDTO dto) {
		int n = session.update("com.exam.config.DeptMapper.update", dto);
		return n;
	}
	
	public int delete ( int deptno) {
		int n = session.delete("com.exam.config.DeptMapper.delete", deptno);
		return n;
	}
	
}
