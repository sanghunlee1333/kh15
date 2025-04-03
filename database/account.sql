drop table account;
create table account (
account_id varchar2(20) primary key,
account_pw varchar2(60) not null,
account_nickname varchar2(30) not null unique,
account_birth char(10),
account_contact char(11),
account_email varchar2(60) not null,
account_level varchar2(12) default '일반회원' not null,
account_point number default 0 not null,
account_post varchar2(6),
account_address1 varchar2(300),
account_address2 varchar2(300),
account_join timestamp default systimestamp not null,
account_login timestamp,
account_change timestamp,
check(regexp_like(account_id, '^[a-z][a-z0-9]{4,19}$')),
check(regexp_like(account_nickname, '^[가-힣0-9]{2,10}$')),
check(regexp_like(account_birth, '^(19[0-9]{2}|20[0-9]{2})-((02-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(account_contact, '^010[1-9][0-9]{7}$')),
check(account_level in ('일반회원', '우수회원', '관리자')),
check(account_point >= 0),
check(regexp_like(account_post, '^[0-9]{5,6}$')),
check(
    (account_post is null and account_address1 is null and account_address2 is null)
    or
    (account_post is not null and account_address1 is not null and account_address2 is not null)
)
);

select * from account;

delete account where account_id = 'testuser1';
commit;
