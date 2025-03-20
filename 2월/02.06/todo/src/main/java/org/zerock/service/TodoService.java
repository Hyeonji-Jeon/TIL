package org.zerock.service;

import java.util.List;

import org.zerock.dao.TodoDAO;
import org.zerock.dto.TodoAddDTO;
import org.zerock.dto.TodoDTO;
import org.zerock.dto.TodoListDTO;

public enum TodoService {
    INSTANCE;

    private TodoService() {
    }

    public void add(TodoAddDTO dto) throws Exception {
        TodoDAO.INSTANCE.insert(dto);
    }

    public List<TodoListDTO> getList(int page) throws Exception {
        return TodoDAO.INSTANCE.list(page);
    }

    public int getTotal() throws Exception {
        return TodoDAO.INSTANCE.getTotal();
    }

    public TodoDTO read(int tno)throws Exception{
    	
    	return TodoDAO.INSTANCE.selectOne(tno);
    	
    }
}
