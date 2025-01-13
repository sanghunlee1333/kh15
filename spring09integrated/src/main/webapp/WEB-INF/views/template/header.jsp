<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
	HTML 코드
	- <!Doctype html>은 HTML의 형태를 선언하기 위한 표식
		- 현재 세계 표준은 HTML 5 (10년 다 되감)
		- 그전에는 4, 4.1, 3.. 등이 사용
	- <html> 은 HTML 문서의 범위를 지정
	- <head> 는 이 문서의 정보를 저장 (편지봉투)
		- <meta> 는 외부에 노출되는 문서의 정보 및 설정
		- <title> 은 브라우저 탭에 표시될 페이지의 제목
	- <body> 는 이 문서의 표시될 내용을 저장 (편지지)
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH15 homepage</title>
</head>
<body>

	<!-- 홈페이지를 헤더, 메뉴, 메인, 푸터로 구분 -->
	
	<!-- (주의) 템플릿 페이지에서는 상대 경로를 쓸 수 없다(실행위치를 모르기 때문) -->
	<div>
		<h1>
			<a href = "/">
			<img src = "/images/kh_logo.png" width = "150" height = "30">
			</a>
			홈페이지 제작 수업
		</h1>
	</div>
	
	<!-- 상태확인용 영역 -->
	<div>
		세션ID : ${pageContext.session.id},
		userId : ${sessionScope.userId}
	</div>
	<!-- 로그인 여부에 따라 메뉴를 다르게 표시 -->
	<div>
		<c:choose>
			<%-- 회원 --%>
			<c:when test = "${sessionScope.userId != null}">
				<a href = "/pokemon/list">포켓몬</a>
				<a href = "/country/list">국가</a>
				<a href = "/game-user/list">게임유저</a>
				<a href = "/member/mypage">내정보</a>
				<a href = "/member/logout">로그아웃</a>
			</c:when>
			
			<%-- 비회원 --%>
			<c:otherwise>
				<a href = "/pokemon/list">포켓몬</a>
				<a href = "/country/list">국가</a>
				<a href = "/member/join">회원가입</a>
				<a href = "/member/login">로그인</a>
			</c:otherwise>
		</c:choose>
		
	</div>
	<hr>
	<div>