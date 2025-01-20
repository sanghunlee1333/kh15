--첨부파일 테이블
drop sequence attachment_seq;
create sequence attachment_seq;

drop table attachment;
create table attachment(
	attachment_no number primary key,
	attachment_name varchar2(255) not null,
	attachment_type varchar2(255) not null,
	attachment_size number not null,
	check(attachment_size >= 0)
);
