package org.zerock.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSecurity
@Log4j2
@RequiredArgsConstructor
public class CustomSecurityConfig {
	
	private final DataSource dataSource;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		log.info("-----------");
		log.info("------securityFilterChain-----");
		log.info("-----------");

		http.formLogin(config -> {
			
			config.loginPage("/member/login");
			config.loginProcessingUrl("/login");
			config.failureHandler(loginFail());
			
		});

		http.rememberMe(config -> {
			config.tokenValiditySeconds(604800);
			config
			.tokenRepository(persistentTokenRepository(dataSource))
			.key("1234567890");
			
		});

		http.csrf(config -> {
			config.disable();
		});
		
		http.exceptionHandling(config ->  {
			config.accessDeniedHandler(accessDeniedHandler());
		});

		return http.build();
	}
	
	@Bean
	public AuthenticationFailureHandler loginFail() {
		
		return new AuthenticationFailureHandler() {
			
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				// TODO Auto-generated method stub
				System.out.println("==================================");
				System.out.println(exception.getMessage());
				
				response.sendRedirect("/member/login?error=bad");
				
			}
		};
		
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		
		return (request, response, accessDeniedException) -> {

			response.sendRedirect("/member/login?error=403");
		};
		
	}
	

	@Bean
	public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		return tokenRepository;
	}
}
