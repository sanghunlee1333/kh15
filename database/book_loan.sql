drop table book_loan;
create table book_loan(
book_loan_no number primary key,
book_loan_title varchar2(90) not null,
book_loan_user varchar2(15) not null,
book_loan_begin timestamp default systimestamp not null,
book_loan_end timestamp default systimestamp+7 not null,
book_loan_return timestamp default null,
book_loan_price number not null,
check(regexp_like(book_loan_title, '^[가-힣]{1,30}$')),
check(regexp_like(book_loan_user, '^[가-힣]{2,5}$')),
check(book_loan_price > 0)
);
drop sequence book_loan_seq;
create sequence book_loan_seq;

INSERT INTO book_loan (book_loan_no, book_loan_title, book_loan_user, book_loan_begin, book_loan_end, book_loan_price)
VALUES (book_loan_seq.nextval, '해리포터와마법사의돌', '이상훈', SYSTIMESTAMP, SYSTIMESTAMP+7, 25000);
commit;
rollback;
select * from country;


CREATE TABLE MEMBER2(

MEMBER_ID varchar2(20) PRIMARY KEY,
MEMBER_PW varchar2(16) NOT NULL,
MEMBER_NICK VARCHAR2(30) NOT NULL UNIQUE,

check(regexp_like(MEMBER_ID, '^[a-zA-Z0-9]{8,20}$')),
check(regexp_like(MEMBER_PW, '^[a-zA-Z0-9!@#$]{8,16}$')),
check(regexp_like(MEMBER_NICK, '^[가-힣]{2,10}$'))


);
drop table MEMBER2;
INSERT INTO MEMBER2 (MEMBER_ID, MEMBER_PW, MEMBER_NICK)
VALUES ('asdASD124','asdASD123#@!','이상훈');

create user khadmin identified by kh1004;
grant conn, resource to khadmin;
conn khadmin/kh1004;
