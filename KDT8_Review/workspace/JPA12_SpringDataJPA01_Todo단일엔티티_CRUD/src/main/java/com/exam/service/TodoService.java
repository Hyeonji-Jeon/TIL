package com.exam.service;

import java.util.List;

import com.exam.dto.TodoDTO;

public interface TodoService {

	//전체Todo 목록보기
	List<TodoDTO> findAll();
	// 저장
	void save(TodoDTO dto);
	//수저
	void update(Long id, TodoDTO dto);
	
	//삭제
    void delete(Long id);
}
