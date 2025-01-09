<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	EL(Expression Language, 표현 언어)
	- 컨트롤러에서 전달된 데이터를 화면에 출력하기 위해 사용하는 언어
	- JSP에서 자바 코드를 직접 사용할 경우 발생하는 부작용을 상쇄 
-->
<h1>당신의 나이 : ${age}</h1>

<!-- 자바 코드 -->	
<h1>당신의 나이 : <%=request.getAttribute("age")%></h1>

