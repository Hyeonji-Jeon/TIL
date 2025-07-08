package com.exam.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.exam.dto.TodoDTO;
import com.exam.entity.Todo;
import com.exam.repository.TodoRepository;

import jakarta.transaction.Transactional;

@Service
public class TodoServiceImpl implements TodoService{

	TodoRepository todoRepository;
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}


	@Override
	public List<TodoDTO> findAll() {
		
		List<Todo> todoList = todoRepository.findAll();
		
		// List<Todo> ===> List<TodoDTO>
		
		List<TodoDTO> todoDTOList = todoList.stream().map(t->{   // t는 Todo
															   TodoDTO dto = TodoDTO.builder()
																	   	     .id(t.getId())
																	   	     .description(t.getDescription())
																	   	     .createdDate(t.getCreatedDate())
																	   	     .lastUpdatedDate(t.getLastUpdatedDate())
																	   	     .done(t.getDone())
																	   	     .build();
															   return dto;
	                                                  	}).collect(Collectors.toList()); 
		
		return todoDTOList;
	}


	@Override
	@Transactional
	public void save(TodoDTO dto) {

		// TodoDTO ---> Todo
		Todo todo = Todo.builder()
					  .id(dto.getId())
			   	      .description(dto.getDescription())
			   	      .done(dto.getDone())
				   .build();
		
		todoRepository.save(todo);
	}


	@Override
	@Transactional
	public void update(Long id, TodoDTO dto) {
		
		// 작업순서
		/*
		   1. id에 해당되는 엔티티 찾기
		   2. 찾은 엔티티를 dto 값으로 수정
		   3. 더티체킹으로 인해서 자동으로 수정
		     또는 save(엔티티) 호출도 가능
		 */
		
		Todo todo = todoRepository.findById(id).orElse(null);
		
		if(todo != null) {
			todo.setDescription(dto.getDescription());
			todo.setDone(dto.getDone());
		}
		// 명시적 호출 가능
//		todoRepository.save(todo);
	}


	@Override
	public void delete(Long id) {
		// 작업순서
		/*
		   1. id에 해당되는 엔티티 찾기
		   2. 찾은 엔티티를 remove 
		 */
		Todo todo = todoRepository.findById(id).orElse(null);
	
		if(todo != null) {
			todoRepository.delete(todo);
//			todoRepository.deleteById(id);
		}
	}

}



