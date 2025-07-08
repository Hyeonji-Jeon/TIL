package com.exam.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class H2DAO {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public H2DAO() {
		
		logger.info("LOGGER: {}", "H2DAO 생성자.");
		
	}
	
}
