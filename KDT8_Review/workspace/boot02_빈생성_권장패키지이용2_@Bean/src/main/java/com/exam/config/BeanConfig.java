package com.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.exam.dao.TodoDAO;
import com.exam.service.TodoServiceImpl;

//우리가 만들지 않은 Bean을 사용할 때
//ex) Spring API
@Configuration
public class BeanConfig {
	
	@Bean
	public TodoServiceImpl createTodoService() {
		return new TodoServiceImpl();
	}

	@Bean
	public TodoDAO createTodoDAO() {
		return new TodoDAO();
	}
}
