package com.kh.spring12.restcontroller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.KakaoPayApproveResponseVO;
import com.kh.spring12.vo.KakaoPayApproveVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/kakaopay/v1")
public class KakaoPayRestControllerV1 {

	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Autowired
	private TokenService tokenService;
	
	//Flash value를 저장하기 위한 저장소
	//- 웹은 기본적으로 멀티스레드 환경이기 때문에 저장소를 만들 때는 "동기화"
	//private Map<주문번호, 결제승인요청정보> flashMap = new HashMap<>(); 
	//private Map<String, KakaoPayApproveVO> flashMap = new HashMap<>(); //non-thread-safe
	
	private Map<String, KakaoPayApproveVO> flashMap = Collections.synchronizedMap(new HashMap<>()); //thread-safe
	
	//현재 거래번호가 완료되면 돌아갈 페이지 주소를 저장
	private Map<String, String> returnUrlMap = Collections.synchronizedMap(new HashMap<>()); //<주문번호, 돌아갈 주소> //thread-safe
	
	@PostMapping("/buy")
	public KakaoPayReadyResponseVO ready(@RequestBody KakaoPayReadyVO vo, @RequestHeader("Frontend-URL") String frontendUrl, @RequestHeader("Authorization") String bearerToken) throws URISyntaxException {
		//vo에는 상품명(itemName)과 결제금액(totalAmount)만 있다
		vo.setPartnerOrderId(UUID.randomUUID().toString());
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		vo.setPartnerUserId(claimVO.getUserId());
		
		//return kakaoPayService.ready(vo);
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo);
		
		//승인을 위해 flashMap에 정보를 저장 //session으로 불가하여 대체
		flashMap.put(vo.getPartnerOrderId(), KakaoPayApproveVO.builder()
					.tid(response.getTid()) //거래번호
					.partnerOrderId(vo.getPartnerOrderId()) //주문번호
					.partnerUserId(vo.getPartnerUserId()) //주문자 //claimVO.getPartnerUserId() 도 가능
				.build());
		
		//사용자가 결제를 요청한 페이지의 주소를 획득 (나중에 돌려보내야 하니까)
		returnUrlMap.put(vo.getPartnerOrderId(), frontendUrl);
		
		return response;
	}
	
	//결제 페이지 매핑의 주소 체계
	//주소 = [/api/kakaopay/v1/buy]
	//성공페이지 = 주소 + /success/주문번호
	//실패페이지 = 주소 + /fail
	//취소페이지 = 주소 + /cancel
	
	@GetMapping("/buy/success/{partnerOrderId}")
	public void success(@PathVariable String partnerOrderId, @RequestParam("pg_token") String pgToken, HttpServletResponse response) throws URISyntaxException, IOException {
		//추가적으로 진행될 내용
		//- 결제 준비에서 처리될 내용들을 이용하여 승인 처리
		KakaoPayApproveVO vo = flashMap.get(partnerOrderId);
		if(vo == null) throw new TargetNotFoundException("유효하지 않은 결제 정보");
		
		flashMap.remove(partnerOrderId);
		vo.setPgToken(pgToken);
		KakaoPayApproveResponseVO approveResponse = kakaoPayService.approve(vo);
		
		//String returnUrl = returnUrlMap.get(partnerOrderId); //복제 추출
		String returnUrl = returnUrlMap.remove(partnerOrderId); //삭제 추출(지우면서 가져옴)
		response.sendRedirect(returnUrl + "/success");
	}
	
	@GetMapping("/buy/cancel/{partnerOrderId}")
	public void cancel(@PathVariable String partnerOrderId, HttpServletResponse response) throws IOException {
		flashMap.remove(partnerOrderId); //없으면 에러가 아니라, 안 지워짐
		String returnUrl = returnUrlMap.remove(partnerOrderId); //삭제 추출(지우면서 가져옴)
		response.sendRedirect(returnUrl + "/cancel");
	}
	
	@GetMapping("/buy/fail/{partnerOrderId}")
	public void fail(@PathVariable String partnerOrderId, HttpServletResponse response) throws IOException {
		flashMap.remove(partnerOrderId); //없으면 에러가 아니라, 안 지워짐
		String returnUrl = returnUrlMap.remove(partnerOrderId); //삭제 추출(지우면서 가져옴)
		response.sendRedirect(returnUrl + "/fail");
	}
	
	
}
