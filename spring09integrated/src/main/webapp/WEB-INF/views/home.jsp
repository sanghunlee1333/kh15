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

<!-- 정적 include -->
<%-- <%@ include file = "/WEB-INF/views/template/header.jsp"%> --%>
    
<!-- 동적 include -->
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    
    
<h1>어서오세요!</h1>
<img src = "http://placehold.co/700x400">

<!-- 정적 include -->
<%-- <%@ include file = "/WEB-INF/views/template/footer.jsp"%> --%>

<!-- 동적 include -->
<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    
