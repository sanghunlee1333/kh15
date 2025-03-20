<%--
	JSP directive (설정 코드)
	- page, include, taglib에 대한 설정을 수행할 수 있는 코드
	- page : 현재 페이지에 대한 기본 설정
		- language : 페이지에서 사용할 프로그래밍 언어(java밖에 안됨)
		- contentType : 현재 페이지의 유형(MIME-TYPE)
		- pageEncoding : 내부적으로 JSP가 변환될 때 적용할 방식
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/bootstrap-header.jsp"></jsp:include>

<!-- 점보트론 -->
<div class="row mt-4">
    <div class="col">
        <div class="bg-dark text-light p-4 rounded">
            <h1>웹 개발자 양성과정 학습자료</h1>
            <p>황인빈 강사의 웹 개발 수업 실습용 홈페이지입니다</p>
        </div>
    </div>
</div>

<!-- 메인 컨텐츠 -->
<div class="row mt-4">
    <div class="col">
        <img src="${pageContext.request.contextPath}/images/welcome.jpg" width="100%">
    </div>
</div>

<jsp:include page="/WEB-INF/views/template/bootstrap-footer.jsp"></jsp:include>