<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	이미지, 음악, 폰트 등을 정적 컨텐츠라 함
	(프로그래밍 요소가 없는 순수한 컨텐츠를 의미)
	
	스프링부트에서 정적컨텐츠는 src/main/resources/static에 저장
-->

<h1>내가 가진 이미지를 출력하는 방법</h1>

<img width = "200" height = "200" src = "http://localhost:8080/images/pikachu.png">
<br>
<img width = "200" height = "200" src = "//localhost:8080/images/pikachu.png">
<br>
<img width = "200" height = "200" src = "/images/pikachu.png">

<!-- 
	현재 페이지를 기준으로 주소를 계산할 수도 있다(상대경로)
	(현재)http://localhost:8080/jsp/test04
	(대상)http://localhost:8080/images/pikachu.jpg
 -->
 
 <br>
 <img width = "200" height = "200" src = "../images/pikachu.png" alt="피카츄의 이미지">