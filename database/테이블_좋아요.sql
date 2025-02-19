create table board_like (
member_id references member(member_id) on delete cascade,
board_no references board(board_no) on delete cascade,
primary key(member_id, board_no)
--unique(member_id, board_no)
);
