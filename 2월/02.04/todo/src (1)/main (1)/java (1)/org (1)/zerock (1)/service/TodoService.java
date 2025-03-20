package org.zerock.service;

import org.zerock.dao.TodoDAO;
import org.zerock.dto.TodoAddDTO;

public enum TodoService {
	
	INSTANCE;
	
	public void add(TodoAddDTO dto)throws Exception{
	
		TodoDAO.INSTANCE.insert(dto);
		
	}
}
