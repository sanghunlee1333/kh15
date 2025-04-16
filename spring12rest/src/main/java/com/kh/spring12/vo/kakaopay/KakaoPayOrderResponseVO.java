package com.kh.spring12.vo.kakaopay;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data 
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoPayOrderResponseVO {
	private String tid; //결제 고유번호
	private String cid; //가맹점 코드
	private String status; //결제 상태
	private String partnerOrderId; //주문번호
	private String partnerUserId; //주문자
	private String paymentMethodType; //결제 수단 (CARD 또는 MONEY)
	
	private KakaoPayAmountVO amount; //결제 금액
	private KakaoPayAmountVO canceledAmount; //취소된 금액
	private KakaoPayAmountVO canceledAvailableAmount; //취소 가능 금액
	
	private String itemName; //상품 이름
	private String itemCode; //상품 코드
	private int quantity; //상품 수량(무조건 1)
	private LocalDateTime createdAt; //결제 준비 요청 시각
	private LocalDateTime approvedAt; //결제 승인 시각
	private LocalDateTime canceledAt; //결제 취소 시각
	
	private KakaoPaySelectedCardInfoVO selectedCardInfo; //결제카드정보
	//private KakaoPayPaymentActionDetails[] paymentActionDetails; //결제/취소 상세 //배열 방식
	private List<KakaoPayPaymentActionDetailsVO> paymentActionDetails; //결제/취소 상세 //리스트 방식
}
