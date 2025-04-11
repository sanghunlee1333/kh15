package com.kh.spring12.kakaopay;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.kh.spring12.configuration.KakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02단건결제승인 {

	@Autowired
	private KakaoPayProperties kakaoPayProperties;

	@Test
	public void test() throws URISyntaxException {

		// (1)전송 도구 생성
		RestTemplate restTemplate = new RestTemplate();

		// (2)전송 주소 확인
//		POST /online/v1/payment/ready HTTP/1.1
//		Host: open-api.kakaopay.com
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");

		// (3)헤더 설정
//		Authorization: SECRET_KEY ${SECRET_KEY}
//		Content-Type: application/json
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
		headers.add("Content-Type", "application/json");

		// (4)바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", "T7f8a6971b530bd8fa69");
		body.put("partner_order_id", "6db42e3a-9036-46d2-a42e-dcbc8a0ad6d3");
		body.put("partner_user_id", "testuser1");
		body.put("pg_token", "623fe1d9123adebc4a48"); //승인은 단 한번만 가능!!!
		
		// (4 + 3)
		// HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
		HttpEntity entity = new HttpEntity(body, headers);

		// 2 + (4 + 3)
		// restTemplate.postForObject(주소객체, 헤더+바디, 결과물의 형태);
		Map response = restTemplate.postForObject(uri, entity, Map.class);
		// log.debug("response = {}", response);
		for (Object name : response.keySet()) {
			Object value = response.get(name);
			log.debug("{} = {}", name, value);
		}

	}

}
