<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>상품권 목록</h1>

<table width = "500">
	<c:forEach var = "giftcardDto" items = "${list}">
	<tr>
		<th width = "30%">
			<img src = "image?giftcardNo=${giftcardDto.giftcardNo}" width = "80%">
		</th>
		<td>
			<h2>${giftcardDto.giftcardName}</h2>
			<p>${giftcardDto.giftcardCharge} 포인트 
				(
				${giftcardDto.giftcardPrice} 원, 
				${giftcardDto.discountRate}% 할인
				)
				<a href = "purchase?giftcardNo=${giftcardDto.giftcardNo}">구매하기</a>
			</p>
			
		</td>
	</tr>
	</c:forEach>
</table>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>   