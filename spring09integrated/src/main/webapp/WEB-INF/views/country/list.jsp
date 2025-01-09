<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>나라 목록</h1>
<h2><a href = "add">신규 등록</a></h2>
<c:forEach var = "countryDto" items = "${list}">
	<h2>
		번호 : ${countryDto.countryNo},
		나라명 : ${countryDto.countryName},
		수도명 : ${countryDto.countryCapital},
		인구수 : ${countryDto.countryPopulation}
	</h2>

</c:forEach>