package com.kh.spring12.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.spring12.configuration.KakaoPayProperties;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

@Service
public class KakaoPayService {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	//결제 준비(ready)
	public KakaoPayReadyResponseVO ready(KakaoPayReadyVO vo) throws URISyntaxException {
		
		//(1)전송 도구 생성
		RestTemplate restTemplate = new RestTemplate();  
		
		//(2)전송 주소 확인
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		//(3)헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
		headers.add("Content-Type", "application/json");
		
		//(4)바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", vo.getPartnerOrderId());
		body.put("partner_user_id", vo.getPartnerUserId());
		body.put("item_name", vo.getItemName());
		body.put("quantity", "1");
		body.put("total_amount", String.valueOf(vo.getTotalAmount()));
		body.put("tax_free_amount", "0");
		body.put("approval_url", "http://localhost:8080/api/kakaopay/v1/approve");
		body.put("cancel_url", "http://localhost:8080/api/kakaopay/v1/cancel");
		body.put("fail_url", "http://localhost:8080/api/kakaopay/v1/fail");
		
		//(4 + 3)
		//HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
		HttpEntity entity = new HttpEntity(body, headers);
		
		//2 + (4 + 3)
		KakaoPayReadyResponseVO response = restTemplate.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
	}
	
	//결제 승인(approve)
//	public KakaoPayApproveResponseVO approve(KakaoPayApproveVo vo) {
//		
//	}
}
