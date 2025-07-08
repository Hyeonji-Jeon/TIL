package com.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.dto.UserDTO;
import com.exam.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	UserMapper mapper;
	
	public UserServiceImpl(UserMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<UserDTO> findAll() {
		return mapper.findAll();
	}

	@Override
	public UserDTO findById(Long id) {
		return mapper.findById(id);
	}

	@Override
	public int save(UserDTO dto) {
		return mapper.save(dto);
	}

	@Override
	public int update(UserDTO dto) {
		return mapper.update(dto);
	}

	@Override
	public int delete(Long id) {
		return mapper.delete(id);
	}

}
