package com.kh.spring12.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

//카카오에서 준비단계 완료 시 보내주는 데이터
//* 주의 : 자동으로 수신하려면 몇 가지 추가 설정이 필요 (jackson-databind)
@Data
@JsonIgnoreProperties(ignoreUnknown = true) //필드에 없는 건 무시하세요!
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //JSON은 snake_case이니까 알아서 변환하세요
public class KakaoPayReadyResponseVO {
	private String tid;
	private String nextRedirectPcUrl; //next_redirect_pr_url;
	private String createdAt; //created_at;
}
