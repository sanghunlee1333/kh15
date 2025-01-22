<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>파일 목록</h1>

<c:forEach var = "attachmentDto" items= "${list}">
	<div>
		${attachmentDto.attachmentName}
		(${attachmentDto.attachmentSizeString})
		
		<a href="download1?attachmentNo=${attachmentDto.attachmentNo}">다운로드1</a>
		<a href="download2?attachmentNo=${attachmentDto.attachmentNo}">다운로드2</a>
		
		<br>
		<img src = "download1?attachmentNo=${attachmentDto.attachmentNo}" width = "100" height = "100">
		<img src = "download2?attachmentNo=${attachmentDto.attachmentNo}" width = "100" height = "100">
	</div>
</c:forEach>