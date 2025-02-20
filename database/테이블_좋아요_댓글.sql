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

drop sequence reply_seq;
create sequence reply_seq;

drop table reply cascade constraint;
create table reply(
reply_no number primary key,
reply_writer references member(member_id) on delete set null,
reply_origin references board(board_no) on delete cascade, 
reply_content varchar2(1500) not null,
reply_wtime timestamp default systimestamp not null,
reply_etime timestamp
);
