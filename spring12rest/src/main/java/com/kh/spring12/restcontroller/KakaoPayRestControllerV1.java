package com.kh.spring12.restcontroller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/api/kakaopay/v1")
public class KakaoPayRestControllerV1 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/ready")
	public KakaoPayReadyResponseVO ready(@RequestBody KakaoPayReadyVO vo, @RequestHeader("Authorization") String bearerToken) throws URISyntaxException {
		//vo에는 상품명(itemName)과 결제금액(totalAmount)만 있다
		vo.setPartnerOrderId(UUID.randomUUID().toString());
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		vo.setPartnerUserId(claimVO.getUserId());
		
		return kakaoPayService.ready(vo);
	}
	
	@GetMapping("/approve")
	public String approve(@RequestParam("pg_token") String pgToken) {
		//추가적으로 진행될 내용
		//- 결제 준비에서 처리될 내용들을 이용하여 승인 처리
		return "승인페이지 - " + pgToken;
	}
	
}
