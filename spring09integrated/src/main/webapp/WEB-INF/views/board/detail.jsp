<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<c:if test="${sessionScope.userId != null}">
<!-- 좋아요 처리 관련 스크립트(회원만) -->
<script type="text/javascript">
	$(function(){
		//자바스크립트에서 파라미터를 읽기 위한 방법
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		
		//시작하자마자 좋아요 여부를 체크하여 결과를 표시
		$.ajax({
			url:"/rest/board/check",
			method: "post",
			data: {boardNo : boardNo},
			success: function(response) { //response에는 done과 count가 있다
				$(".fa-heart").removeClass("fa-solid fa-regular").addClass(response.done ? "fa-solid" : "fa-regular");
				$(".heart-count").text(response.count);
			}
		});
		
		//하트를 클릭하면 좋아요 설정/해제를 구현
		$(".fa-heart").click(function(){
			$.ajax({
				url:"/rest/board/action",
				method: "post",
				data: {boardNo : boardNo},
				success: function(response) { //response에는 done과 count가 있다
					$(".fa-heart").removeClass("fa-solid fa-regular").addClass(response.done ? "fa-solid" : "fa-regular");
					$(".heart-count").text(response.count);
				}
			});
		});
		
	});
</script>
</c:if>

<h1>${boardDto.boardTitle}</h1>
<div>
<%-- ${boardDto.boardWriter} --%>
<%-- ${memberDto.memberId} --%>	
	${memberDto.memberNickname}
	(${memberDto.memberLevel})
	<br>
	${boardDto.boardWtime}
	조회 ${boardDto.boardRead}
</div>
<hr>

<div style = "min-height:200px">
	<pre>${boardDto.boardContent}</pre></div>
<hr>
<div>
	<i class="fa-heart fa-regular red"></i>
	좋아요 <span class = "heart-count">${boardDto.boardLike}</span>
	댓글 ${boardDto.boardReply}
</div>

<div>
	<a href="write">글쓰기</a>
	<a href="write?boardTarget=${boardDto.boardNo}">답글쓰기</a>
	
	<!-- 소유자일 경우에만 수정과 삭제 표시 -->
	<c:if test = "${sessionScope.userId != null}"> <!-- 탈퇴해서 작성자가 null인상태와 비로그인 상태의 null도 소유자로 판단하게 되므로 이 경우도 안되게 처럼 -->
		<c:if test = "${sessionScope.userId == boardDto.boardWriter}">
			<a href="edit?boardNo=${boardDto.boardNo}">수정</a> 
			<a href="delete?boardNo=${boardDto.boardNo}">삭제</a>
		</c:if>
	</c:if>
	
	<a href="list">목록</a>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>