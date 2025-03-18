<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- Lightpick 라이브러리 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/css/lightpick.min.css">
<script src="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/lightpick.min.js"></script>
<!-- kakao post api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/js/member/join.js"></script>

<!-- kakao map cdn -->
<style>
	#map {
		width:300px;
		height:200px;
		display:none;
	}
</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=430cecda328081e9c3c1420be135b9dd&libraries=services"></script>
<script type="text/javascript">
	$(function(){
		$("[name=memberAddress2]").blur(function(){
			var post = $("[name=memberPost]").val();
			var address1 = $("[name=memberAddress1]").val();
			var address2 = $("[name=memberAddress2]").val();
			
			var isFill = post.length > 0 && address1.length > 0 && address2.length > 0;
			
			if(isFill) {
				//지도 생성(+주소 검색)
				$("#map").show();
				
				var address = address1 + " " + address2;
				
				//주소-좌표 변환도구 생성
                var geocoder = new kakao.maps.services.Geocoder();

                //도구를 이용해서 좌표를 검색
                //geocoder.addressSearch(주소, 콜백함수);
                geocoder.addressSearch(address, function(result, status){
                    //console.log(arguments);//함수에 전달되는 모든 인자를 확인
                    //if(status == "OK") {//검색 성공
                    if(status === kakao.maps.services.Status.OK) {//검색 성공
                        //console.log(result[0].x, result[0].y);//경도, 위도
                        
                        var location = new kakao.maps.LatLng(result[0].y, result[0].x);
                        
                        //지도 생성
                        var container = document.querySelector("#map");//JS
                        var options = {
							center: new kakao.maps.LatLng(location.getLat(), location.getLng()),
							level: 3
                        };
                        var map = new kakao.maps.Map(container, options);
                        map.setDraggable(false);
                        map.setZoomable(false);
                        
                        //마커 생성
                        var marker = new kakao.maps.Marker({
                            map: map,//지도 설정
                            position: location,//위치 설정
                        });
                    }
                    else {
						$("#map").empty().hide();                    	
                    }
                });
			}
			else {
				//지도 삭제
				$("#map").empty().hide();
			}
		});
	});
</script>


<!-- <h1>가입 정보 입력</h1>

<form action = "join" method="post"> 메소드=포스트를 안써주면 뺑뻉 돈다 
	* 아이디 <input type = "text" name = "memberId" required> <br><br>
	* 비밀번호 <input type = "password" name = "memberPw" required> <br><br>
	* 닉네임 <input type = "text" name = "memberNickname" required> <br><br>
	* 이메일 <input type = "email" name = "memberEmail" required> <br><br> text로도 가능 
	생년월일 <input type = "date" name = "memberBirth"> <br><br>
	연락처 <input type = "tel" name = "memberContact"> <br><br>
	주소 <br>
	<input type = "text" name = "memberPost" size = "6" placeholder = "우편번호"> <br>
	<input type = "text" name = "memberAddress1" size = "60" placeholder = "기본주소"> <br> 기본 입력창 사이즈가 20
	<input type = "text" name = "memberAddress2" size = "60" placeholder = "상세주소"> <br><br>
	<button>회원가입</button>
</form> -->

<form class="form-check" action="" method="post" autocomplete="off">
	<div class="container w-500">
		<div class="cell center">
			<h1>가입 정보 입력</h1>
		</div>
		<div class="cell">
			<label>아이디 <i class="fa-solid fa-asterisk red"></i></label> <input
				type="text" name="memberId" class="field w-100">
			<div class="success-feedback">멋진 아이디입니다!</div>
			<div class="fail-feedback">아이디는 알파벳으로 시작하며 숫자를 포함한 8~20자로 작성하세요</div>
			<div class="fail2-feedback">아이디가 이미 사용중입니다</div>
		</div>
		<div class="cell">
			<label>비밀번호 <i class="fa-solid fa-asterisk red"></i></label> <input
				type="password" name="memberPw" class="field w-100">
			<div class="success-feedback">비밀번호가 올바른 형식입니다</div>
			<div class="fail-feedback">알파벳 대문자, 소문자, 숫자, 특수문자를 반드시 한 글자 이상
				포함해서 8~16자로 작성하세요</div>
		</div>
		<div class="cell">
			<label>비밀번호 확인 <i class="fa-solid fa-asterisk red"></i></label> <input
				type="password" id="pw-reinput" class="field w-100">
			<div class="success-feedback">비밀번호가 일치합니다</div>
			<div class="fail-feedback">비밀번호가 일치하지 않습니다</div>
			<div class="fail2-feedback">비밀번호를 먼저 형식에 맞게 작성하세요</div>
		</div>
		<div class="cell">
			<label>닉네임 <i class="fa-solid fa-asterisk red"></i></label> <input
				type="text" name="memberNickname" class="field w-100">
			<div class="success-feedback">멋진 닉네임이네요!</div>
			<div class="fail-feedback">닉네임은 한글 또는 숫자 2~10자로 작성하세요</div>
			<div class="fail2-feedback">닉네임이 이미 사용중입니다</div>
		</div>
		<div class="cell">
			<label style="display: block;">이메일 <i class="fa-solid fa-asterisk red"></i></label> 
			<input type="email" inputmode="email" name="memberEmail" class="field">
			<button type="button" class="btn btn-neutral btn-send-cert">
				<i class="fa-solid fa-paper-plane"></i> 
				<span>인증메일 발송</span>
			</button>
			<div class="fail-feedback">이메일은 필수 항목입니다</div>
		</div>
		<div class="cell cert-input-wrapper" style="display: none;">
			<input type="text" inputmode="numeric" class="field" name="certNumber" placeholder="인증번호 입력">
			<button type="button" class="btn btn-positive btn-confirm-cert">
				<i class="fa-solid fa-check"></i> 
				<span>인증 확인</span>
			</button>
			<div class="success-feedback">인증이 완료되었습니다</div>
			<div class="fail-feedback">인증번호가 일치하지 않습니다</div>
		</div>
		<div class="cell">
			<label>생년월일</label> <input type="text" name="memberBirth"
				class="field w-100">
		</div>
		<div class="cell">
			<label>연락처</label> <input type="tel" name="memberContact"
				class="field w-100">
			<div class="fail-feedback">010으로 시작하는 휴대전화번호를 작성하세요</div>
		</div>
		<div class="cell">
			<label>주소</label>
		</div>
		<div class="cell">
			<input type="text" name="memberPost" size="6" maxlength="6"
				class="field" placeholder="우편번호" readonly>
			<button type="button" class="btn btn-neutral btn-address-search">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
			<button type="button" class="btn btn-negative btn-address-clear"
				style="display: none;">
				<i class="fa-solid fa-xmark"></i>
			</button>
		</div>
		<div class="cell">
			<input type="text" name="memberAddress1" class="field w-100"
				placeholder="기본주소" readonly>
		</div>
		<div class="cell">
			<input type="text" name="memberAddress2" class="field w-100"
				placeholder="상세주소">
			<div class="fail-feedback">주소는 모두 작성하셔야 합니다</div>
		</div>
		
		<!-- 지도 영역 -->
		<div class="cell">
			<div id="map"></div>
		</div>

		<div class="cell mt-30">
			<button type="submit" class="btn btn-positive w-100">회원가입</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>