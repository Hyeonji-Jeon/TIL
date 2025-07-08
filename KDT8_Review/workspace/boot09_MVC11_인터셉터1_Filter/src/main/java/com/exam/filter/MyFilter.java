package com.exam.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {

		logger.info("LOGGER:  {}", "요청 필터");

		chain.doFilter(request, response);
		
		logger.info("LOGGER:  {}", "응답 필터");
		
	}
}
