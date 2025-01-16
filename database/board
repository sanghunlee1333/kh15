drop sequence board_seq;
create sequence board_seq;
	
drop table board;
create table board(
board_no number primary key,
board_title varchar2(300) not null,
board_content varchar2(3000) not null,
-- 게시글 작성자는 반드시 존재하는 회원의 ID인 경우만 추가할 수 있어야 한다
-- 이러한 항목들을 외래키(Foreign Key)라고 부른다
-- 단, 회원이 탈퇴하면 어떻게 할지 지정해야 하는데..
-- [1] 회원이 탈퇴하면 그 회원의 모든 글을 삭제(on delete cascade)
-- [2] 회원이 탈퇴하면 해당 회원의 아이디만 null로 변경(on delete set null)
board_writer references member(member_id) on delete set null,
board_wtime timestamp default systimestamp not null,
board_etime timestamp,
board_like number default 0 not null,
board_read number default 0 not null,
board_reply number default 0 not null,
check(board_like >= 0),
check(board_read >= 0),
check(board_reply >= 0)
);

--select max(board_no) from board
select board_seq.nextval from dual

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(1, '첫 번째 게시글입니다', '안녕하세요. 이 게시판에 첫 번째로 글을 씁니다.', 'tkdgnsdl133', SYSTIMESTAMP, NULL, 5, 20, 2);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(2, '오늘의 날씨', '오늘은 화창한 날씨네요. 산책하기 좋은 날입니다.', 'testuser2', SYSTIMESTAMP - INTERVAL '1' DAY, NULL, 10, 50, 5);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(3, '맛집 추천해주세요', '서울에서 맛있는 파스타 맛집 어디 있을까요?', 'tkdgnsdl13', SYSTIMESTAMP - INTERVAL '2' DAY, NULL, 15, 100, 20);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(4, '영화 리뷰: 인셉션', '크리스토퍼 놀란 감독의 인셉션을 보고 왔습니다. 정말 멋진 영화였어요!', 'tkdgnsdl133', SYSTIMESTAMP - INTERVAL '3' DAY, NULL, 50, 200, 30);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(5, '운동 팁 공유', '매일 30분 걷기만 해도 건강에 큰 도움이 됩니다.', 'testuser2', SYSTIMESTAMP - INTERVAL '4' DAY, NULL, 20, 150, 15);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(6, '프로그래밍 질문', 'Java에서 스트림을 어떻게 사용하나요?', 'tkdgnsdl13', SYSTIMESTAMP - INTERVAL '5' DAY, NULL, 8, 80, 12);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(7, '여행 계획 세우기', '다음 달에 제주도 여행을 갑니다. 추천 코스 있나요?', 'tkdgnsdl133', SYSTIMESTAMP - INTERVAL '6' DAY, NULL, 25, 180, 40);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(8, '책 추천', '최근에 읽은 좋은 책 추천해주세요.', 'testuser2', SYSTIMESTAMP - INTERVAL '7' DAY, NULL, 12, 90, 18);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(9, '취미 공유', '저는 주말마다 등산을 갑니다. 여러분의 취미는 무엇인가요?', 'tkdgnsdl13', SYSTIMESTAMP - INTERVAL '8' DAY, NULL, 30, 220, 45);

INSERT INTO board (board_no, board_title, board_content, board_writer, board_wtime, board_etime, board_like, board_read, board_reply) VALUES
(10, '오늘의 명언', '노력은 배신하지 않는다.', 'testuser2', SYSTIMESTAMP - INTERVAL '9' DAY, NULL, 100, 500, 50);

commit;
