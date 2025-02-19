create table board_like (
member_id references member(member_id) on delete cascade,
board_no references board(board_no) on delete cascade,
primary key(member_id, board_no)
--unique(member_id, board_no)
);


--포켓몬 테이블에 좋아요 항목 추가
alter table pokemon add(pokemon_like number) 

create table pokemon_like (
member_id references member(member_id) on delete cascade,
pokemon_no references pokemon(pokemon_no) on delete cascade,
primary key(member_id, pokemon_no)
--unique(member_id, pokemon_no)
);
