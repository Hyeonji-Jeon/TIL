package com.exam.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.TodoDTO;
import com.exam.service.TodoService;


@RestController
public class TodoController {

	TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<TodoDTO>> findAll() {

		List<TodoDTO> todoDTOList = todoService.findAll();
		return ResponseEntity.status(200).body(todoDTOList);
	}
	
	
	/*
	  headers: Content-Type:application/json
	  body:
	      {
	         "id":10004,
	        "description":"SQL in 50 Steps",
	        "done":false
	      }
	
	*/
	@PostMapping("/todos")
	public ResponseEntity<TodoDTO> save(@RequestBody TodoDTO dto){
		
		todoService.save(dto);
		return ResponseEntity.created(null).body(dto); // 201
	}
	/*
	  headers: Content-Type:application/json
	  
	  /todos/10004
	  body:
	      {
	        "description":"SQL in 100 Steps",
	        "done": true
	      }
	
	*/
	@PutMapping("/todos/{id}")
	public ResponseEntity<TodoDTO> update(@PathVariable Long id,
			                               @RequestBody TodoDTO dto){
		
		todoService.update(id, dto);
		
		return ResponseEntity.status(201).body(dto); // 201
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<TodoDTO> delete(@PathVariable Long id){
		
		todoService.delete(id);
		return ResponseEntity.noContent().build(); // 204
	}
}
