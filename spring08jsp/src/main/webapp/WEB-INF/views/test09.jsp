<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	EL의 특징
	- 추론 기능을 제공 
-->
<h1>time = ${time}</h1>
<h1>연도 = ${time.getYear()}</h1>
<h1>연도 = ${time.year}</h1> <!-- 추론 형태 -->
<h1>월 = ${time.getMonthValue()}</h1>
<h1>월 = ${time.monthValue}</h1>