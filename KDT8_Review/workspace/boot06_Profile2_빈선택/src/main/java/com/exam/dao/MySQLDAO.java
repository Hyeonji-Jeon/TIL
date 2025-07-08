package com.exam.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("prod")
public class MySQLDAO {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public MySQLDAO() {
		logger.info("LOGGER: {}", "MySQLDAO 생성자.");
	}
}
