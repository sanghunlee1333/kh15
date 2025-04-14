package com.kh.spring12.restcontroller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

import com.kh.spring12.dao.ItemDao;
import com.kh.spring12.dto.ItemDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.KakaoPayService;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.KakaoPayApproveResponseVO;
import com.kh.spring12.vo.KakaoPayApproveVO;
import com.kh.spring12.vo.kakaopay.KakaoPayBuyVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/kakaopay/v2")
public class KakaoPayRestControllerV2 {

	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Autowired
	private TokenService tokenService;
	
	//Flash value를 저장하기 위한 저장소
	private Map<String, KakaoPayApproveVO> flashMap = Collections.synchronizedMap(new HashMap<>()); //thread-safe
		
	//현재 거래번호가 완료되면 돌아갈 페이지 주소를 저장
	private Map<String, String> returnUrlMap = Collections.synchronizedMap(new HashMap<>()); //<주문번호, 돌아갈 주소> //thread-safe
	
	//구매 요청 시 클라이언트가 {상품번호, 수량}을 배열 형태로 전송
	//- 클래스를 만들어서 받을 수 있돋록 준비해야한다
	@PostMapping("/buy")
	public KakaoPayReadyResponseVO buy(@RequestBody List<KakaoPayBuyVO> buyList, 
									@RequestHeader("Frontend-URL") String frontendUrl, 
									@RequestHeader("Authorization") String bearerToken) throws URISyntaxException {
		if(buyList.isEmpty()) throw new TargetNotFoundException();
		
		KakaoPayReadyVO vo = new KakaoPayReadyVO();
		vo.setPartnerOrderId(UUID.randomUUID().toString());
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		vo.setPartnerUserId(claimVO.getUserId());
		
		//결제에 필요한 정보를 계산 (itemName, totalAmount)
		//- 상품명(itemName) : 상품이 1개일 때는 해당 상품명, 2개 이상이면 ???외 ?건
		StringBuffer buffer = new StringBuffer();
		ItemDto firstItemDto = itemDao.selectOne(buyList.get(0).getItemNo());
		buffer.append(firstItemDto.getItemName());
		if(buyList.size() >= 2) {
			buffer.append(" 외 " + (buyList.size() - 1) + "건");
		}
		vo.setItemName(buffer.toString());
		
		//- 합계(totalAmount) : buyList의 모든 항목을 조회하여 할인금액 * 수량
		int totalAmount = 0;
		for(KakaoPayBuyVO buyVO : buyList) {
			ItemDto itemDto = itemDao.selectOne(buyVO.getItemNo()); //상품정보 구하기
			totalAmount += itemDto.getRealPrice() * buyVO.getQty();
		}
		vo.setTotalAmount(totalAmount);
		
		KakaoPayReadyResponseVO response = kakaoPayService.ready(vo); //vo에 정보 4개
		
		//다음 매핑을 위한 추가 정보를 저장
		flashMap.put(vo.getPartnerOrderId(), KakaoPayApproveVO.builder()
					.partnerOrderId(vo.getPartnerOrderId())
					.partnerUserId(vo.getPartnerUserId())
					.tid(response.getTid())
				.build());
		returnUrlMap.put(vo.getPartnerOrderId(), frontendUrl);
		
		return response;
	}
	
	@GetMapping("/buy/success/{partnerOrderId}")
	public void success (@PathVariable String partnerOrderId, @RequestParam("pg_token") String pgToken, HttpServletResponse response) throws URISyntaxException, IOException {
		KakaoPayApproveVO vo = flashMap.remove(partnerOrderId);
		if(vo == null) throw new TargetNotFoundException("유효하지 않은 결제 정보");
		
		flashMap.remove(partnerOrderId);
		vo.setPgToken(pgToken);
		KakaoPayApproveResponseVO approveResponse = kakaoPayService.approve(vo);
	
		//DB에 결제완료된 정보를 저장하는 처리를 추가
		
		String returnUrl = returnUrlMap.remove(partnerOrderId);
		response.sendRedirect(returnUrl + "/success");
	}
	
//	@GetMapping("/buy/cancel/{partnerOrderId}")
//	@GetMapping("/buy/fail/{partnerOrderId}")
	
	
	
}
