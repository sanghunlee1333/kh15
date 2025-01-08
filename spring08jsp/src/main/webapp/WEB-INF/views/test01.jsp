<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 글씨쓰고 드래그한다음 ctrl + shift + c = 주석 처리 -->
<!-- 
	JSP
	- Java Server Page
	- 자바에서 HTML 페이지를 만들어내기 위한 중간 단계의 파일
	- 자바의 코드와 HTML 태그를 섞어쓸 수 있다
	- 우선 HTML을 먼저 배우고 JSP의 문법을 추가해서 배운다
	
	HTML
	- 웹페이지의 구조를 만드는 언어(HyperText Markup Language)
	- 태그(tag)를 이용하여 영역을 만들고 효과를 부여
	
	h로 시작하는 태그를 heading 태그라 부른다 (h1~h6, hr)
	
	
-->

<h1>안녕하세요!</h1>
<h2>안녕하세요!</h2>
<h3>안녕하세요!</h3>
<hr>
<h4>안녕하세요!</h4>
<h5>안녕하세요!</h5>
<h6>안녕하세요!</h6>

<!-- 
	a태그는 외부 페이지로 이동할 수 있는 링크를 만들 때 사용 
	- 태그만으로 정보가 부족할 때는 속성(attribute)을 사용하여 정보를 표기 
-->
<a href="https://google.com">구글로 이동</a>

<!-- 
	태그는 중첩하여 사용할 수 있다
	- 길어지면 줄바꿈을해도 무관(HTML은 <br>로 줄바꿈을 하므로 엔터는 자유롭게 사용 가능)
	- 영역은 반드시 한쪽이 더 작아야 한다
	- 태그에 따라서 바깥에 쓸 수 없는 태그가 존재(다 외울 수 없고 상식적인 것만)
 -->
 <h1>
 	<a href="https://www.naver.com">
 		네이버로 이동
 	</a>
 </h1>