package com.exam.config;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {


	//SessionLocaleResolver 생성
	@Bean
	   // 메서드는 반드시 localeResolver() 메서드만 가능하다.
		public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver =
				new SessionLocaleResolver();
		
		//기본 locale 설정
		localeResolver.setDefaultLocale(new Locale("ko"));
		return localeResolver;
	}
	
	// LocalChangeInterceptor 생성
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor xxx = new LocaleChangeInterceptor();
		// ?lang=en|ja|ko  또는 ?locale=en|ja|ko , ?xxx=en|ja|ko
		// (default parameter name: "locale").
		xxx.setParamName("lang");
		return xxx;
	}
	
	// LocalChangeInterceptor 등록
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(localeChangeInterceptor());
	}
	
	
}


