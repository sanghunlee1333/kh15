package com.kh.spring12.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.spring12.aop.AccountLoginInterceptor;

@Configuration
public class InterCeptorConfiguration implements WebMvcConfigurer {

	@Autowired
	private AccountLoginInterceptor accountLoginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accountLoginInterceptor)
				.addPathPatterns("/api/country/**");
	}
}
