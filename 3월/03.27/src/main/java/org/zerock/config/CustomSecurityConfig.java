package org.zerock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity
@Log4j2
public class CustomSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {

		log.info("----------------");
		log.info("--------securityFilterChain--------");
		log.info("----------------");
		
		http.formLogin(config -> {});
		
		http.rememberMe(config -> {
			config.tokenValiditySeconds(604800);
		});

		http.csrf(config -> {
			config.disable();
		});
		
		return http.build();
	}


}
