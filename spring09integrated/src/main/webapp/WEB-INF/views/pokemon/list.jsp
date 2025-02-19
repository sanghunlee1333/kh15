<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:if test="${sessionScope.userLevel == '관리자'}">
<script type = "text/javascript">
	$(function(){
		$(".form-delete").submit(function(){
			var checkItems = $(".check-item:checked"); 
			if(checkItems.length == 0) {//만약에 체크된것이 없다면
				window.alert("항목을 먼저 선택해야 합니다");
				return false;
			}
			
			return window.confirm("정말 삭제하시겠습니까?");
		});
	});
</script>
</c:if>


<%-- <h1>포켓몬 목록</h1>
<h2><a href = "add">신규 등록</a></h2> <!-- 상대경로 = add / 절대경로 = /pokemon/add -->

<table border="1" width="400">
	<thead>
		<tr>
			<th>이미지</th>
			<th>번호</th>
			<th>이름</th>
			<th>속성</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="pokemonDto" items="${list}">
		<tr>
			<td>
				<img src="image?pokemonNo=${pokemonDto.pokemonNo}" width="50" height="50">
			</td>
			<td>${pokemonDto.pokemonNo}</td>
			<td>
				<a href="detail?pokemonNo=${pokemonDto.pokemonNo}">
					${pokemonDto.pokemonName}
				</a>
			</td>
			<td>${pokemonDto.pokemonType}</td>
		</tr>
		</c:forEach>
	</tbody>
</table> --%>

<c:if test="${sessionScope.userLevel == '관리자'}">
<!-- 전체 삭제를 위해 테이블 전체를 감싸는 form 생성 -->
<form class = "form-delete" action = "deleteAll" method = "post">
</c:if>
<div class="container w-500">
	<div class="cell center"><h1>포켓몬 목록</h1></div>
	<div class="cell right">
		<c:if test="${sessionScope.userLevel == '관리자'}">
		<button type = "submit" class = "btn btn-negative">체크항목 삭제</button>
		</c:if>	
        <a href = "add" class = "btn btn-neutral">신규 등록</a>
    </div>

	<div class="cell">
		<table class="table table-border table-stripe table-hover table-ellipsis">
			<thead>
				<tr>
					<c:if test="${sessionScope.userLevel == '관리자'}">
					<th>
						<input type = "checkbox" class = "check-all">
					</th>
					</c:if>
					<th>이미지</th>
					<th>번호</th>
					<th>이름</th>
					<th>속성</th>
					<th>좋아요</th>
				</tr>
			</thead>
			<tbody class="center">
				<c:forEach var="pokemonDto" items="${list}">
					<tr>
						<c:if test="${sessionScope.userLevel == '관리자'}">
						<td>
							<input type = "checkbox" class = "check-item" name = "pokemonNo" value = "${pokemonDto.pokemonNo}">
						</td>
						</c:if>
						<td>
							<img src="image?pokemonNo=${pokemonDto.pokemonNo}" width="50" height="50">
						</td>
						<td>${pokemonDto.pokemonNo}</td>
						<td style = "max-width: 200px">
							<a href="detail?pokemonNo=${pokemonDto.pokemonNo}">
								${pokemonDto.pokemonName} 
							</a>
						</td>
						<td>${pokemonDto.pokemonType}</td>
						<td>${pokemonDto.pokemonLike}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<c:if test="${sessionScope.userLevel == '관리자'}">
</form>
</c:if>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>