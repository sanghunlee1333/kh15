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
