<!-- 
	JSP directive (설정 코드) 
	- page, include, taglib에 대한 설정을 수행할 수 있는 코드
	- page : 현재 페이지에 대한 기본 설정
		- language : 페이지에서 사용할 프로그래밍 언어 (java밖에 안됨) 안 적어도 됨
		- contentTyape : 현재 페이지의 유형(MIME-TYPE) ex)audio/mp3, text/plain -> 대분류/소분류
		- pageEncoding : 내부적으로 JSP가 변환될 때 적용할 방식
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 정적 include -->
<%-- <%@ include file = "/WEB-INF/views/template/header.jsp"%> --%>
    
<!-- 동적 include -->	
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    
    
<h1>어서오세요!</h1>
<img src = "${pageContext.request.contextPath}/images/welcome.jpg">


<c:if test="${cookie.adblock == null}">

<%-- 광고 화면 및 오늘 하루 안보기 기능 구현 --%>
<style>
	.ad-wrapper {
		box-shadow: 0 0 1px 1px black;
		background-color: white;
		padding: 20px;
		
		position: fixed;
		z-index: 99999;
		
		top:50%;
		left:50%;
		transform: translate(-50%, -50%);
	}
</style>

<script type = "text/javascript">
	$(function(){
		$(".ad-wrapper").find(".btn-ad-close").click(function(e){
			e.preventDefault(); //a태그는 반드시 기본 이벤트에 대한 방지..? 가 필요함
			$(".ad-wrapper").fadeOut(); //remove, hide
		});
		$(".ad-wrapper").find(".btn-ad-close-today").click(function(e){
			e.preventDefault(); 
			$.ajax({
				url:"/rest/cookie/ad",
				method:"get",
				//data:{},
				success: function(response){
					$(".ad-wrapper").fadeOut(); //remove, hide
				}
			});
		});
	});
</script>
<div class = "ad-wrapper">
	<div class = "cell">
		<h3>마감 임박!</h3>
	</div>
	<div class = "cell">
		지금 OOO 강사의 수업이 마감 직전입니다. <br>
		어서 서두르세요!
	</div>
	<div class = "cell mt-30 float-box">
		<a class = "float-left btn-ad-close-today" href = "#">오늘 하루 안보기</a>
		<a class = "float-right btn-ad-close" href = "#">닫기</a>
	</div>
</div>

</c:if>

<!-- 정적 include -->
<%-- <%@ include file = "/WEB-INF/views/template/footer.jsp"%> --%>

<!-- 동적 include -->
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    
