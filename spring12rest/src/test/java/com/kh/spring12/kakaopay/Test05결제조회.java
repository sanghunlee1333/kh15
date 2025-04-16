package com.kh.spring12.kakaopay;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test05결제조회 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		KakaoPayOrderVO vo = KakaoPayOrderVO.builder()
								.tid("T7fddcc4555b0f379a98")
							.build();
		
		KakaoPayOrderResponseVO response = kakaoPayService.order(vo);
		log.debug("조회 성공!");
	}
	
}
