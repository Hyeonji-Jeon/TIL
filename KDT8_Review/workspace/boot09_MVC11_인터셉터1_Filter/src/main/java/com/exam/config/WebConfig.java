package com.exam.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.exam.filter.MyFilter;

// MyFilter 등록
@Configuration
public class WebConfig implements WebMvcConfigurer {

	// 직접 등록
	@Bean
	public FilterRegistrationBean<MyFilter>  myFilter(){
		FilterRegistrationBean<MyFilter> filter = 
				new FilterRegistrationBean<MyFilter>(new MyFilter());
		
		filter.addUrlPatterns("/*");  // web.xml의 <url-pattern>/*</url-pattern>
		return filter;
	}
	
}
