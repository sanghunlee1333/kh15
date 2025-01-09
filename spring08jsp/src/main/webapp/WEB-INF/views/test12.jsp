<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>테이블(table) 배우기</h1>

<table border = "1" width = "300"><!-- 전체 테이블 영역 -->
	<thead> <!-- 테이블 헤더(제목 영역) -->
		<tr bgcolor = "#74b9ff"> <!-- 한줄 --> <!-- Flat UI Colors 사이트 -->
			<th>번호</th> <!-- 한칸 -->
			<th>이름</th> <!-- th - 제목을 위한 칸 : 굵은 글씨 및 가운데 정렬 -->
			<th>나이</th>
			<th>성별</th>
		</tr>
	</thead>
	<tbody align = "center"> <!-- 테이블 바디(데이터 영역) -->
		<tr>
			<td>1</td>
			<td>김철수</td>
			<td>30</td>
			<td>남</td>
		</tr>
		<tr>
			<td>2</td>
			<td>오영희</td>
			<td>25</td>
			<td>여</td>
		</tr>
	</tbody>

<!-- 
	<tfoot>
	</tfoot> 
-->

</table>