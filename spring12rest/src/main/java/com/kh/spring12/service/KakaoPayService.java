package com.kh.spring12.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring12.configuration.KakaoPayProperties;
import com.kh.spring12.dao.BuyDao;
import com.kh.spring12.dao.ItemDao;
import com.kh.spring12.dto.BuyDetailDto;
import com.kh.spring12.dto.BuyDto;
import com.kh.spring12.dto.ItemDto;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayApproveVO;
import com.kh.spring12.vo.kakaopay.KakaoPayBuyVO;
import com.kh.spring12.vo.kakaopay.KakaoPayCancelResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayCancelVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayOrderVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyResponseVO;
import com.kh.spring12.vo.kakaopay.KakaoPayReadyVO;

@Service
public class KakaoPayService {
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	@Autowired
	private BuyDao buyDao;
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HttpHeaders headers;
	
	
	//결제 준비(ready)
	public KakaoPayReadyResponseVO ready(KakaoPayReadyVO vo) throws URISyntaxException {
		
		//(1)전송 도구 생성
//		RestTemplate restTemplate = new RestTemplate();  
		
		//(2)전송 주소 확인
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/ready");
		
		//(3)헤더 설정
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
//		headers.add("Content-Type", "application/json");
		
		//(4)바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("partner_order_id", vo.getPartnerOrderId());
		body.put("partner_user_id", vo.getPartnerUserId());
		body.put("item_name", vo.getItemName());
		body.put("quantity", "1");

		body.put("total_amount", String.valueOf(vo.getTotalAmount()));
		body.put("tax_free_amount", "0");
		//카카오페이 개발자센터 플랫폼에 등록된 주소로 시작해야함
		//<규칙>
		//- 어떠한 주소가 오든 그 주소 뒤에 /success, /fail, /cancel을 붙인다
		//- 성공 시에는 partnerOrderId를 경로변수로 추가
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequest().toUriString(); //현재 요청에 대한 주소를 구함
		//body.put("approval_url", "http://localhost:8080/api/kakaopay/v1/success/" + vo.getPartnerOrderId());
		body.put("approval_url", baseUrl + "/success/" + vo.getPartnerOrderId());
		//body.put("cancel_url", "http://localhost:8080/api/kakaopay/v1/cancel");
		body.put("cancel_url", baseUrl + "/cancel" + vo.getPartnerOrderId());
		//body.put("fail_url", "http://localhost:8080/api/kakaopay/v1/fail");
		body.put("fail_url", baseUrl + "/fail" + vo.getPartnerOrderId());
		
		//(4 + 3)
		//HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
		HttpEntity entity = new HttpEntity(body, headers);
		
		//2 + (4 + 3)
		KakaoPayReadyResponseVO response = restTemplate.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
	}
	
	//결제 승인(approve)
	public KakaoPayApproveResponseVO approve(KakaoPayApproveVO vo) throws URISyntaxException {
		// (1)전송 도구 생성
//		RestTemplate restTemplate = new RestTemplate();

		// (2)전송 주소 확인
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/approve");

		// (3)헤더 설정
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", "SECRET_KEY " + kakaoPayProperties.getSecretKey());
//		headers.add("Content-Type", "application/json");

		// (4)바디 설정
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", vo.getTid());
		body.put("partner_order_id", vo.getPartnerOrderId());
		body.put("partner_user_id", vo.getPartnerUserId());
		body.put("pg_token", vo.getPgToken()); //승인은 단 한번만 가능!!!
		
		// (4 + 3)
		// HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);
		HttpEntity entity = new HttpEntity(body, headers);
		
		// 2 + (4 + 3)
		KakaoPayApproveResponseVO response = restTemplate.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		return response;
	}
	
	//결제 조회(order)
	public KakaoPayOrderResponseVO order(KakaoPayOrderVO vo) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/order");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", vo.getTid());
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		return restTemplate.postForObject(uri, entity, KakaoPayOrderResponseVO.class);
	}
	
	//결제 취소(cancel)
	public KakaoPayCancelResponseVO cancel(KakaoPayCancelVO vo) throws URISyntaxException {
		URI uri = new URI("https://open-api.kakaopay.com/online/v1/payment/cancel");
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", kakaoPayProperties.getCid());
		body.put("tid", vo.getTid());
		body.put("cancel_amount", String.valueOf(vo.getCancelAmount()));
		body.put("cancel_tax_free_amount", "0");
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		return restTemplate.postForObject(uri, entity, KakaoPayCancelResponseVO.class);
	}
	
	//결제DB에 등록
	@Transactional
	public void insertDB(KakaoPayApproveVO approveVO, KakaoPayReadyVO readyVO, List<KakaoPayBuyVO> buyList) {
		//buy 등록
		long buyNo = buyDao.addBuy(BuyDto.builder()
						.buyOwner(approveVO.getPartnerUserId()) //주문자
						.buyTid(approveVO.getTid()) //거래번호
						.buyName(readyVO.getItemName()) //구매상품명
						.buyTotal(readyVO.getTotalAmount()) //구매금액
					.build());
		
		//buy_detail 등록
		for(KakaoPayBuyVO buyVO : buyList) {
			ItemDto itemDto = itemDao.selectOne(buyVO.getItemNo());
			buyDao.addBuyDetail(BuyDetailDto.builder()
				.buyDetailOrigin(buyNo) //구매대표번호
				.buyDetailItem(buyVO.getItemNo()) //구매상품번호
				.buyDetailName(itemDto.getItemName()) //구매상품명
				.buyDetailPrice(itemDto.getRealPrice()) //구매상품가격(개당)
				.buyDetailQty(buyVO.getQty()) //구매상품개수
					.build());
		}
	}
	
}
