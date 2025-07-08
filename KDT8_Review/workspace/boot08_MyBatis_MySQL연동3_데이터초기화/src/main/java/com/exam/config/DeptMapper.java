package com.exam.config;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.DeptDTO;

@Mapper
public interface DeptMapper {

	public List<DeptDTO> findAll();
	public DeptDTO findByDeptno(int deptno);
	 
    public int save(DeptDTO dto);
    public int update(DeptDTO dto);
    public int delete(int deptno);
	
}
