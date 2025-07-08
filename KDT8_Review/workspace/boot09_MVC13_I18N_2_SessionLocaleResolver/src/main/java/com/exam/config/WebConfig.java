package com.exam.config;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {


	//SessionLocaleResolver
	
	@Bean
	   // 메서드는 반드시 localeResolver() 메서드만 가능하다.
		public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver =
				new SessionLocaleResolver();
		
		//기본 locale 설정
		localeResolver.setDefaultLocale(new Locale("ko"));
		return localeResolver;
	}
}
//	@Bean
//	public ArrayList<String> xxx(){
//		return new ArrayList<>();
//	}

