package com.kh.spring09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling //스케쥴러 활성화
@SpringBootApplication
public class Spring09integratedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring09integratedApplication.class, args);
	}

}
