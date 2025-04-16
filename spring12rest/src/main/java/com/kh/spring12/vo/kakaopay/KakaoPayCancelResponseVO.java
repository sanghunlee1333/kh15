package com.kh.spring12.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data 
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoPayCancelResponseVO {
	private String aid; //요청 고유 번호
	private String tid; //거래 고유번호
	private String cid; //가맹점 코드
	private String status; //결제 상태
	private String partnerOrderId; //주문번호
	private String partnerUserId; //주문자
	private String paymentMethodType; //CARD 또는 MONEY
	
	private KakaoPayAmountVO amount; //결제금액
	private KakaoPayAmountVO approvedCanceledAmount; //이번 요청으로 취소된 금액
	private KakaoPayAmountVO canceledAmount; //누계 취소 금액
	private KakaoPayAmountVO cancelAvailableAmount; //남은 취소 가능 금액
	
	private String itemName; //결제요청이름
	private String itemCode; //상품코드
	private Integer quantity; //상품수량
	private LocalDateTime createdAt; //결제 준비시각
	private LocalDateTime approvedAt; //결제 승인시각
	private LocalDateTime canceledAt; //결제 취소시각
	private String payload; //결제 시 추가한 텍스트
	
}
