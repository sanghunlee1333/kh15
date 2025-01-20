drop sequence board_seq;
create sequence board_seq;

delete board;
commit;
	
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

--테이블을 지우지 않고 항목만 변경
--alter table 테이블 명 add/modify/drop 항목정보
alter table board add(
	board_group number not null,
	board_target number,
	board_depth number not null,
	check(board_group > 0),
	check(board_target > 0),
	check(board_depth >= 0)
);

--더미 데이터 추가
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(1, '첫 번째 게시글', '.', 'testuser1', 1, null, 0);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(2, '두 번째 게시글', '.', 'testuser1', 2, null, 0);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(3, '세 번째 게시글', '.', 'testuser1', 3, null, 0);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(4, '네 번째 게시글', '.', 'testuser1', 3, 3, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(5, '다섯 번째 게시글', '.', 'testuser1', 3, 3, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(6, '여섯 번째 게시글', '.', 'testuser1', 3, 4, 2);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) 
commit;

insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(7, '일곱 번째 게시글', '.', 'testuser1', 7, null, 0);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(8, '여덟 번째 게시글', '.', 'testuser1', 7, 7, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(9, '아홉 번째 게시글', '.', 'testuser1', 7, 7, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(10, '열 번째 게시글', '.', 'testuser1', 7, 8, 2);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(11, '열한 번째 게시글', '.', 'testuser1', 7, 8, 2);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(12, '열두 번째 게시글', '.', 'testuser1', 7, 7, 1);
insert into board(board_no, board_title, board_content, board_writer, board_group, board_target, board_depth) values(13, '열세 번째 게시글', '.', 'testuser1', 13, null, 0);
commit;

--게시글을 조회하겠습니다
--select 항목 from board;

--게시글은 상하관계가 있습니다(트리 구조이며 글번호↑ = 타겟번호↓)
--connect by prior board_no = board_target

--연결된 구조의 시작점은 상위글이 없는 항목입니다
--start with board_target is null

--조회할 때는 연결 항목을 우선시하고
--order siblings by

--(1) 그룹이 큰 것부터
--board_group desc,

--(2) 번호가 작은 것부터
--board_no asc



--게시글 목록을 조회하면서 회원의 정보를 연결해서 조회(table join)
--select 항목 from 테이블A 조인키워드 테이블B on 조인조건;
--조인키워드 (inner join, outer join)
--inner join은 서로 연결된 항목이 존재하는 것들만 출력 (커플만 조회)
--outer join은 특정 테이블을 기준으로 연결과 상관없이 출력 (커플, 싱글 모두 조회)
-- * outer join 시 중요한 테이블을 먼저 쓰고 left outer join으로 연결

--view는 테이블은 아니고 구문을 테이블 처럼 보이게 함(insert 불가 -> 조회용)
grant create view to kh15;
create or replace view board_list_view as --create or replace -> view는 지웠다가 다시 만들 필요없음
select 
	T.board_no target_no, T.board_title target_title,
	B.board_no, B.board_title, B.board_content, 
	B.board_writer, B.board_wtime, B.board_etime,
	B.board_like, B.board_read, B.board_reply, 
	B.board_group, B.board_target, B.board_depth,
	M.*
	from board B 
		left outer join member M on B.board_writer=M.member_id --left/right outer join--
		left outer join board T on T.board_no = B.board_target;
		
select * from board_list_view;


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

BEGIN
    FOR i IN 1..1000 LOOP
        INSERT INTO board (board_no, board_title, board_content, board_writer)
        VALUES (
            board_seq.nextval,
            CASE MOD(i, 10)
                WHEN 0 THEN '오늘 하루 어땠나요?'
                WHEN 1 THEN '맛집 추천 좀 해주세요!'
                WHEN 2 THEN '최근 본 영화 추천받아요'
                WHEN 3 THEN '자바 개발 공부 어떻게 하시나요?'
                WHEN 4 THEN '강아지 산책하기 좋은 곳 추천'
                WHEN 5 THEN '취업 준비 어떻게 하고 계신가요?'
                WHEN 6 THEN '내일 날씨 아시는 분?'
                WHEN 7 THEN '좋은 책 추천해주세요'
                WHEN 8 THEN 'IT 트렌드에 대해 이야기해요'
                ELSE '오늘 운동 다녀오신 분?'
            END,
            CASE MOD(i, 10)
                WHEN 0 THEN '오늘 하루도 고생 많으셨어요! 다들 어떻게 보내셨나요?'
                WHEN 1 THEN '서울에 분위기 좋은 맛집 추천 부탁드립니다!'
                WHEN 2 THEN '요즘 재미있게 본 영화 있으신가요? 추천해 주세요!'
                WHEN 3 THEN '자바 웹 개발 공부 방법 공유해요!'
                WHEN 4 THEN '강아지랑 산책하기 좋은 공원 어디 있을까요?'
                WHEN 5 THEN '취업 준비 중인데, 정보 공유해요!'
                WHEN 6 THEN '내일 우산 챙겨야 할까요? 날씨 아시는 분!'
                WHEN 7 THEN '자기계발에 도움 되는 책 추천 부탁드려요.'
                WHEN 8 THEN '요즘 뜨는 IT 기술에 대해 이야기 나눠요.'
                ELSE '운동 루틴 공유해요! 오늘 어떤 운동 하셨나요?'
            END,
            CASE WHEN MOD(i, 2) = 0 THEN 'testuser1' ELSE 'testuser3' END
        );
    END LOOP;
END;

SELECT COUNT(*) FROM board;
