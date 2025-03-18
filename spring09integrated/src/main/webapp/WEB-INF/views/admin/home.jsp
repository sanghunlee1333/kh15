<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>관리자 홈</h1>

<h2><a href = "${pageContext.request.contextPath}/admin/member/list">회원 관리</a></h2>

<h2><a href = "${pageContext.request.contextPath}/admin/giftcard/add">상품권 등록</a></h2>
<h2><a href = "${pageContext.request.contextPath}/admin/giftcard/list">상품권 관리</a></h2>

<h2><a href = "${pageContext.request.contextPath}/admin/status/pokemon">포켓몬 현황</a></h2>
<h2><a href = "${pageContext.request.contextPath}/admin/status/game-user">게임유저 현황</a></h2>
<h2><a href = "${pageContext.request.contextPath}/admin/status/member">회원 현황</a></h2>
<h2><a href = "${pageContext.request.contextPath}/admin/status/member-join">회원가입 현황</a></h2>
<h2><a href = "${pageContext.request.contextPath}/admin/status/board-write">게시글 작성 현황</a></h2>


<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>   