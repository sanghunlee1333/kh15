<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>이메일 인증 테스트</h1>

<h2>[1] 동기방식으로 인증메일 보내기</h2>

<form action = "test1" method = "post">
	<input type = "email" inputmode = "email" name = "email">
	<button type = "submit">인증메일 보내기</button>
</form>

<!-- ------------------------------------------------ -->
<h2>[2] 비동기방식으로 인증메일 보내기</h2>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type = "text/javascript">
$(function(){
	$(".btn-send-cert").click(function(){
		$.ajax({
			url: "/rest/cert/send",
			method: "post",
			data: { email : $(".email-input").val() },
			success: function(success){
				console.log("이메일 발송 완료");
				$(".cert-input-wrapper").show();
			},
			//beforeSend - 전송 전 자동 실행되는 콜백함수 설정 가능
			//error - 통신 오류 발생 시 자동 실행되는 콜백함수 설정 영역
			//complete - 오류와 관계없이 통신 완료 시 자동 실행되는 콜백함수 설정 영역
			beforeSend: function(){
				$(".btn-send-cert").prop("disabled", true).text("인증메일 발송 중...");
			},
			complete: function(){
				$(".btn-send-cert").prop("disabled", false).text("인증메일 보내기");
			},
		});
		
	});
	
	$(".btn-confirm-cert").click(function(){
		var email = $(".email-input").val();
		var number = $(".cert-input").val();
		//차단 상황은 추후 구현
		$.ajax({
			url: "/rest/cert/check",
			method: "post",
			data: { certEmail : email, certNumber : number },
			success: function(response){
				console.log("결과", response);
				if(response == true) {
					$(".cert-input-wrapper").hide();
					$(".btn-send-cert").prop("disabled", true).text("인증 완료");
				}
			},
				beforeSend: function(){},
				complete: function(){}
		});
		
	});
	
});
</script>

<form action = "test2" method = "post">
	<input type = "email" inputmode = "email" name = "email" class = "email-input">
	<button type = "button" class = "btn-send-cert">인증메일 보내기</button>
	
	<div class = "cert-input-wrapper" style="display:none">
		<input type = "text" inputmode = "numeric" class = "cert-input">
		<button type = "button" class = "btn-confirm-cert">인증번호 확인</button>
	</div>
</form>