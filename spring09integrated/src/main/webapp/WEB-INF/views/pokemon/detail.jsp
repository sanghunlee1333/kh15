<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<c:if test="${sessionScope.userId != null}">
<!-- 좋아요 처리 관련 스크립트(회원만) -->
<script type="text/javascript">
	$(function(){
		//자바스크립트에서 파라미터를 읽기 위한 방법
		var params = new URLSearchParams(location.search);
		var pokemonNo = params.get("pokemonNo");
		
		//시작하자마자 좋아요 여부를 체크하여 결과를 표시
		$.ajax({
			url:"/rest/pokemon/check",
			method: "post",
			data: {pokemonNo : pokemonNo},
			success: function(response) { //response에는 done과 count가 있다
				$(".fa-heart").removeClass("fa-solid fa-regular").addClass(response.done ? "fa-solid" : "fa-regular");
				$(".heart-count").text(response.count);
			}
		});
		
		//하트를 클릭하면 좋아요 설정/해제를 구현
		$(".fa-heart").click(function(){
			$.ajax({
				url:"/rest/pokemon/action",
				method: "post",
				data: {pokemonNo : pokemonNo},
				success: function(response) { //response에는 done과 count가 있다
					$(".fa-heart").removeClass("fa-solid fa-regular").addClass(response.done ? "fa-solid" : "fa-regular");
					$(".heart-count").text(response.count);
				}
			});
		});
		
	});
</script>
</c:if>

<h1>[${pokemonDto.pokemonName}] 몬스터 정보</h1>

<!-- 동적 이미지 주소 (참고)헤더에는 정적 이미지 주소 사용했음 -->
<img src = "image?pokemonNo=${pokemonDto.pokemonNo}" width = "300">

<table border="1" width="300">
	<tr>
		<th width="30%">번호</th>
		<td>${pokemonDto.pokemonNo}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${pokemonDto.pokemonName}</td>
	</tr>
	<tr>
		<th>속성</th>
		<td>${pokemonDto.pokemonType}</td>
	</tr>
</table>

<div>
	<i class="fa-heart fa-regular red"></i>
	좋아요 <span class = "heart-count">${pokemonDto.pokemonLike}</span>
</div>

<h2>
	<a href="add">신규등록</a> 
	<a href="list">목록보기</a> 
	<a href="edit?pokemonNo=${pokemonDto.pokemonNo}">수정하기</a> 
	<a href="delete?pokemonNo=${pokemonDto.pokemonNo}">삭제하기</a>
</h2>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>