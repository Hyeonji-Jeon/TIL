package org.zerock.service;

import org.zerock.dao.TodoDAO;
import org.zerock.dto.TodoAddDTO;
import org.zerock.dto.TodoListDTO;

public enum TodoService {

	INSTANCE;
	
	public void add(TodoAddDTO dto)throws Exception{
		
		TodoDAO.INSTANCE.insert(dto);
		
	}
	
	public java.util.List<TodoListDTO> getList(int page) throws Exception{
		
		return TodoDAO.INSTANCE.list(page);
		
	}
	
}
