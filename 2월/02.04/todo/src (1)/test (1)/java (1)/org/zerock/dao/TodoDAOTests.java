package org.zerock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.zerock.dto.TodoAddDTO;

public class TodoDAOTests {

	@Test
	public void test1()throws Exception {
		
		System.out.println(TodoDAO.INSTANCE);

		String now = TodoDAO.INSTANCE.makeConnection();
		
		System.out.println(now);
	}
	
	@Test
	public void testInsert()throws Exception {
		
		TodoAddDTO dto = new TodoAddDTO();
		dto.setTitle("한글 Test Code Title");
		dto.setWriter("user00");
		
		TodoDAO.INSTANCE.insert(dto);
		
	}
	
}










