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

<!-- 댓글 관련 스크립트 -->
<script type = "text/javascript">
	$(function(){
		//글 번호 읽기
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		
		//최소 1회 목록을 불러오도록 처리
		loadList();
		
		//.btn-reply-write를 누르면 댓글 등록 ajax 요청을 전송
		$(".btn-reply-write").click(function(){
			var replyContent = $(".reply-input").val();
			if(replyContent.length == 0){
				window.alert("내용을 작성하세요");
				return
			}
			
			$.ajax({
				url: "/rest/reply/write",
				method: "post",
				data: {
					replyOrigin : boardNo,
					replyContent : replyContent
				},
				success: function(response){
					$(".reply-input").val(""); //입력값 제거
					loadList(); //목록 다시 불러오기 -> 내가 댓글을 작성하는 사이, 다른 댓글이 등록됐을 수 있으므로
				}
			});
		});
		
		//댓글 삭제
		//.btn-reply-delete를 누르면 삭제 요청을 보내세요
		//$(".btn-reply-delete").click(function(){}); -> 안됨(버튼이 아직 안만들어짐)
		$(document).on("click", ".btn-reply-delete", function(){//문서전체 감시
			//this == 클릭한 삭제 버튼
			var choice = window.confirm("정말 댓글을 삭제하시겠습니까?");
			if(choice == false) return;
			
			var replyNo = $(this).data("reply-no");
			//var replyNo = $(this).attr("data-reply-no");
			
			$.ajax({
				url: "/rest/reply/delete",
				method: "post",
				data: {
					replyNo : replyNo
				},
				success: function(response){
					loadList();
				}
			});
		});
		
		//댓글 수정
		$(document).on("click", ".btn-reply-edit", function(){
			//#reply-edit-template을 불러와서 값을 옮긴 뒤 추가
			
			//기존에 열려있는 모든 수정화면을 제거
			$(".reply-edit-item").prev(".reply-item").show();
			$(".reply-edit-item").remove();
			
			//원본은 놔두고 원본 뒤에다 추가
			var template = $("#reply-edit-template").text();
			var html = $.parseHTML(template);
			
			//값을 옮기는 작업이 필요 (총 5개)
			var writerProfile = $(this).closest(".reply-item").find(".writer-profile").prop("src");
			var replyWriter = $(this).closest(".reply-item").find(".reply-writer").text();
			var replyContent = $(this).closest(".reply-item").find(".reply-content").text();
			var replyWtime = $(this).closest(".reply-item").find(".reply-wtime").text();
			var replyNo = $(this).data("reply-no");
			
			$(html).find(".writer-profile").prop("src", writerProfile);
			$(html).find(".reply-writer").text(replyWriter);
			$(html).find(".reply-content").val(replyContent);
			$(html).find(".reply-wtime").text(replyWtime);
			$(html).find(".btn-reply-save").attr("data-reply-no", replyNo);
			
			$(this).closest(".reply-item").after(html); //append 그것의 안쪽에서 맨 뒤에 붙이기. after는 그것의 바로 뒤에
			$(this).closest(".reply-item").hide();
		});
		
		$(document).on("click", ".btn-reply-save", function(){
			//저장을 누르면 작성한 내용을 서버로 전송해 수정 요청하고 목록 갱신
			var replyNo = $(this).data("reply-no");
			var replyContent = $(this).closest(".reply-edit-item").find(".reply-content").val();
			if(replyContent.length == 0){
				window.alert("내용은 필수입니다");
				return;
			}
			
			$.ajax({
				url: "/rest/reply/edit",
				method: "post",
				data: {
					replyNo : replyNo,
					replyContent : replyContent
				},
				success: function(response){
					loadList(); //목록 갱신
				}
			});
		});
		
		$(document).on("click", ".btn-reply-cancel", function(){
			//취소를 누르면 현재 수정 영역을 제거하고 앞의 표시 영역을 출력
			var choice = window.confirm("댓글 수정을 취소하시겠습니까?");
			if(choice == false) return;
			
			$(this).closest(".reply-edit-item").prev(".reply-item").show();
			$(this).closest(".reply-edit-item").remove();
		});
		
		//목록을 불러오는 함수
		function loadList() {
			$.ajax({
				url: "/rest/reply/list",
				method: "post",
				data: { replyOrigin: boardNo },
				success: function(response) { //List<ReplyDto> - JSON(배열)
					$(".reply-wrapper").empty(); //비우기
					$(response).each(function(){ //for문과 동일한 기능
						//매 항목(this)에 대해서 템플릿을 불러와 값을 설정한 뒤 추가
						var template = $("#reply-template").text();
						var html = $.parseHTML(template);
						
						//변환할거 하고
						$(html).find(".reply-writer").text(this.replyWriter);
						$(html).find(".reply-content").text(this.replyContent);
						$(html).find(".reply-wtime").text(this.replyWtime);
						$(html).find(".btn-reply-edit").attr("data-reply-no", this.replyNo);
						$(html).find(".btn-reply-delete").attr("data-reply-no", this.replyNo);
						
						//추가
						$(".reply-wrapper").append(html); //prepend는 최신 것이 달림
					});
					$(".reply-count").text(response.length); //댓글 개수 갱신
				}
			});
		}
	});
</script>
<script type = "text/template" id = "reply-template">
	<div class = "reply-item flex-box">
		<div class = "w-150 center p-10">
			<img class = "writer-profile w-75" src = "https://placehold.co/200?text=P">
		</div>
		<div class = "w-100 p-10">
			<h3 class = "my-0 reply-writer">작성자</h3>
			<p class = "reply-content">작성내용</p>
			<span class = "reply-wtime">yyyy-MM-dd HH:mm:ss</span>
		</div>
		<div class = "w-150 flex-box flex-vertical p-10">
			<button type = "button" class = "btn btn-negative btn-reply-edit">
				<i class = "fa-solid fa-edit"></i> 수정
			</button>
			<button type = "button" class = "btn btn-negative btn-reply-delete mt-10">
				<i class = "fa-solid fa-trash"></i> 삭제
			</button>
		</div>
	</div>
</script>

<script type = "text/template" id = "reply-edit-template">
	<div class = "reply-edit-item flex-box">
		<div class = "w-150 center p-10">
			<img class = "writer-profile w-75" src = "https://placehold.co/200?text=P">
		</div>
		<div class = "w-100 p-10">
			<h3 class = "my-0 reply-writer">작성자</h3>
			<textarea class = "reply-content field w-100">작성내용</textarea>
			<span class = "reply-wtime">yyyy-MM-dd HH:mm:ss</span>
		</div>
		<div class = "w-150 flex-box flex-vertical p-10">
			<button type = "button" class = "btn btn-positive btn-reply-save">
				<i class = "fa-solid fa-floppy-disk"></i> 저장
			</button>
			<button type = "button" class = "btn btn-negative btn-reply-cancel mt-10">
				<i class = "fa-solid fa-xmark"></i> 취소
			</button>
		</div>
	</div>
</script>

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
	댓글 <span class = "reply-count">${boardDto.boardReply}</span>
</div>

<!-- 댓글 목록과 댓글 작성란이 표시되는 영역 -->
<div class = "reply-wrapper mt-20"></div>
<div class = "mt-20">
	<textarea class = "field w-100 reply-input" rows="4"></textarea>
	<div class = "right">
		<button type = "button" class = "btn btn-positive btn-reply-write">
			<i class = "fa-solid fa-pen"></i> 등록
		</button>
	</div>
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