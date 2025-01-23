<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>일시적인 오류가 발생했습니다</h1>
<p>
	잠시 후 다시 한번 실행해주세요
	<br>
	${message}
</p>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>