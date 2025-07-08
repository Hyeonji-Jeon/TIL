package com.exam.service;

import java.util.List;

import com.exam.dto.UserDTO;

public interface UserService {

	public List<UserDTO> findAll();
	public UserDTO findById(Long id);
	
	public int save(UserDTO dto);
	public int update(UserDTO dto);
	public int delete(Long id);
}
