package com.kh.spring12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//Spring Security가 프로젝트에 적용되는 것을 제거하는 설정
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Spring12restApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring12restApplication.class, args);
	}

}
