package com.kh.spring12.mybatis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j //Lombok에서 제공하는 자동 로거 생성 어노테이션
@SpringBootTest
public class Test06로그남기기 {

	//로그를 남기려면 로깅 도구를 생성해야 한다
	//slf4j - 임포트 (어댑터 라이브러리)
	Logger log = LoggerFactory.getLogger(Test06로그남기기.class);
	
	@Test
	public void test() {
		log.debug("안녕 난 디버그야");
		log.info("안녕 난 인포야");
		log.warn("안녕 난 경고메세지야");
		log.error("안녕 난 에러메세지야");
		
		//로그의 좋은 점 : 더하기 그만 써도 된다
		int a = 10;
		int b = 20;
		System.out.println(a + " + " + b + " = " + (a + b));
		log.debug("a = {}", a);
		log.debug("{} + {} = {}", a, b, a + b);
	}
}
