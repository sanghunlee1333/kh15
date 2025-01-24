<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>마이페이지</h1>

<table border = "1" width = "500">
	<tr>
		<th width = "35%">아이디</th>
		<td>${memberDto.memberId}</td>
	</tr>
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
			[${memberDto.memberPost}]
			${memberDto.memberAddress1}
			${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint} point</td>
	</tr>
	<tr>
		<th>가입일시</th>
		<td>
		<fmt:formatDate value = "${memberDto.memberJoin}" pattern = "y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>최종로그인</th>
		<td>
		<fmt:formatDate value = "${memberDto.memberLogin}" pattern = "y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>비밀번호 변경일</th>
		<td>
		<fmt:formatDate value = "${memberDto.memberChange}" pattern = "y년 M월 d일 a h시 m분 s초"/>
		</td>
	</tr>
</table>

<!-- 구매내역 출력 -->
<h1>포인트 구매내역</h1>

<table border = "1">
	<thead>
		<tr>
			<th>구매항목</th>
			<th>구매금액</th>
			<th>구매일시</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var = "purchaseHistoryDto" items = "${purchaseHistoryList}">
		<tr>
			<td>${purchaseHistoryDto.giftcardName}</td>
			<td>${purchaseHistoryDto.giftcardPurchaseTime}</td>
			<td>
				${purchaseHistoryDto.giftcardPrice}원
				x
				${purchaseHistoryDto.giftcardPurchaseQty}개
				=
				${purchaseHistoryDto.giftcardPurchaseTotal}원 
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<h2><a href = "password">비밀번호 변경</a></h2> <!-- 같은 위치에 있다 -> 엔드포인트가 같다 /member/password = /password -->
<h2><a href = "change">개인정보 변경</a></h2>
<h2><a href = "exit">회원 탈퇴</a></h2>


<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>