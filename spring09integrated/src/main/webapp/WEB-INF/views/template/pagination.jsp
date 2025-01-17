<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!-- 페이지 네이게이터 : pageVO에 기반하여 처리하도록 구현 -->
<!-- 이전 : startBlock > 1 일 경우 출력 -->
<h3>
<c:if test = "${pageVO.hasPrevBlock()}"> <!-- @Data로 표준규칙으로 만들어지지 않기 때문에 해당 메소드로만 가능 -->
	<a href = "list?page=${pageVO.prevBlock}&${pageVO.parameters}">
		&lt;
	</a>
<!-- 아래는 이제 필요 없음	 -->
<%-- 	<c:choose> --%>
<%-- 		<c:when test = "${pageVO.search}"> <!-- pageVo.isSearch() 메소드로도 대체 가능 --> --%>
<%-- 			<a href = "list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${pageVO.prevBlock}&size=${pageVO.size}">&lt;</a> --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<%-- 			<a href = "list?page=${pageVO.prevBlock}&size=${pageVO.size}">&lt;</a> --%>
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
</c:if>

<!-- 숫자 -->
<%-- for(int i = 1; i <= 10; i++) {} --%>
<c:forEach var = "i" begin = "${pageVO.startBlock}" end = "${pageVO.finishBlock}" step = "1">
	<a href="list?page=${i}&${pageVO.parameters}">${i}</a>
<!-- 아래는 이제 필요 없음	 -->
<%-- 	<c:choose> --%>
<%-- 		<c:when test = "${pageVO.search}"> --%>
<%-- 			<a href = "list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${i}&size=${pageVO.size}">${i}(검색)</a>   --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<%-- 			<a href = "list?page=${i}&size=${pageVO.size}">${i}(목록)</a> --%>
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
</c:forEach>

<!-- 다음 : finishBlock < pageCount 일 경우 출력 -->
<c:if test = "${pageVO.hasNextBlock()}">
	<a href = "list?page=${pageVO.nextBlock}&${pageVO.parameters}">
		&gt;
	</a>
<!-- 아래는 이제 필요 없음	 -->
<%-- 	<c:choose> --%>
<%-- 		<c:when test = "${pageVO.search}"> --%>
<%-- 			<a href = "list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${pageVO.nextBlock}&size=${pageVO.size}">&gt;</a> --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<%-- 			<a href = "list?page=${pageVO.nextBlock}&size=${pageVO.size}">&gt;</a> --%>
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
</c:if>
</h3>