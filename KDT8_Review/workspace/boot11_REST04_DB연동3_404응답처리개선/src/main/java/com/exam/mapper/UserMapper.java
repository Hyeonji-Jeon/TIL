package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.UserDTO;

@Mapper
public interface UserMapper {

	public List<UserDTO> findAll();
	public UserDTO findById(Long id);
	
	public int save(UserDTO dto);
	public int update(UserDTO dto);
	public int delete(Long id);
	
}
