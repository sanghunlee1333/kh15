package com.kh.spring12.kakaopay;

import java.net.URISyntaxException;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03단건결제준비모듈화 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		KakaoPayReadyVO vo = KakaoPayReadyVO.builder()
					.partnerOrderId(UUID.randomUUID().toString())
					.partnerUserId("testuser1")
					.itemName("배그Gcoin교환권")
					.totalAmount(1000000L)
				.build();
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		log.debug("vo = {}", vo);
		log.debug("response = {}", response);
	}
}
