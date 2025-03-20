<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Layout</title>

    <!-- google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

    <!-- font awesome cdn -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"/>

	<!-- moment -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/moment.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.30.1/locale/ko.min.js"></script>

    <!-- jQuery cdn -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
    	$.ajaxSetup({//ajax 초기 설정
    		beforeSend: function(xhr, settings) {//전송 직전에 호출되는 전처리
    			if(settings.url.startsWith("/")) {//통신주소가 슬래시로 시작하면
    				//context path를 계산하여 추가하겠다
    				settings.url = "${pageContext.request.contextPath}" + settings.url;
    			}
    		}
    	});
    </script>

    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.3/cosmo/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">

    </script>

</head>

<body>

    <!-- 메뉴(Navbar) -->
    <nav class="navbar navbar-expand-lg bg-dark fixed-top" data-bs-theme="dark">
        <div class="container-fluid">

            <!-- 좌측 로고(텍스트 또는 이미지) -->
            <a class="navbar-brand" href="${pageContext.request.contextPath}/bootstrap-home">KH정보교육원</a>

            <!-- 메뉴 펼침 버튼(폭이 작을 때만 나옴) -->
            <button class="navbar-toggler" type="button" 
                    data-bs-toggle="collapse" 
                    data-bs-target="#main-menu"
                    aria-controls="main-menu" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- 실제 메뉴 영역(폭에 따라 보이는 형태가 다름) -->
            <div class="collapse navbar-collapse" id="main-menu">
                <!-- 좌측 메뉴 -->
                <ul class="navbar-nav me-auto">
                	<li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}">
                            <i class="fa-solid fa-house"></i>
                            클래식페이지
                        </a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" 
                            data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="true" aria-expanded="false">
                            <i class="fa-solid fa-database"></i>
                            데이터관리
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/pokemon/list">포켓몬스터정보</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/country/list">국가정보</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/game-user/list">게임유저정보</a>
                            <!-- <div class="dropdown-divider"></div> -->
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/board/list">
                            <i class="fa-solid fa-list-ul"></i>
                            게시판
                        </a>
                    </li>
                    <c:if test="${sessionScope.userId != null && sessionScope.userLevel != '관리자'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/giftcard/list">
                            <i class="fa-solid fa-sack-dollar"></i>
                            상품권구매
                        </a>
                    </li>
                    </c:if>
                </ul>
                
                <!-- 우측 메뉴 -->
                <ul class="navbar-nav">
                	<c:if test="${sessionScope.userId == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/member/join">
                            <i class="fa-solid fa-user"></i>
                            회원가입
                        </a>
                    </li>
                	<li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/member/login">
                            <i class="fa-solid fa-right-to-bracket"></i>
                            로그인
                        </a>
                    </li>
                	</c:if>
                	<c:if test="${sessionScope.userId != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/member/mypage">
                            <i class="fa-solid fa-user"></i>
                            ${sessionScope.userId}
                        </a>
                    </li>
                    <c:if test="${sessionScope.userLevel == '관리자'}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/member/mypage">
                            <i class="fa-solid fa-cog"></i>
                            관리메뉴
                        </a>
                    </li>
                    </c:if>
                	<li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/member/logout">
                            <i class="fa-solid fa-bracket-to-right"></i>
                            로그아웃
                        </a>
                    </li>
                	</c:if>
                    
                </ul>
            </div>
        </div>
    </nav>


    <!-- 컨테이너 -->
    <div class="container mt-5 pt-5">