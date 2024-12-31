drop table member;
create table member (
member_id varchar2(20) primary key,
member_pw varchar2(16) not null,
member_nickname varchar2(30) not null unique,
member_birth char(10),
member_contact char(11),
member_email varchar2(60) not null,
member_level varchar2(12) default '일반회원' not null,
member_point number default 0 not null,
member_post varchar2(6),
member_address1 varchar2(300),
member_address2 varchar2(300),
member_join timestamp default systimestamp not null,
member_login timestamp,
member_change timestamp,
check(regexp_like(member_id, '^[a-z][a-z0-9]{4,19}$')),
check(
  regexp_like(member_pw, '^[A-Za-z0-9!@#$]{8,16}$')
  and
  regexp_like(member_pw, '[A-Z]+')
  and
  regexp_like(member_pw, '[a-z]+')
  and
  regexp_like(member_pw, '[0-9]+')
  and
  regexp_like(member_pw, '[!@#$]+')
),
check(regexp_like(member_nickname, '^[가-힣0-9]{2,10}$')),
--[ㄱ-ㅎㅏ-ㅣ가-힣] 자음, 모음까지 허용할 경우
check(regexp_like(member_birth, '^(19[0-9]{2}|20[0-9]{2})-((02-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(member_contact, '^010[1-9][0-9]{7}$')),
check(member_level in ('일반회원', '우수회원', '관리자')),
check(member_point >= 0),
check(regexp_like(member_post, '^[0-9]{5,6}$')),
-- 셋다 없는/있는 경우
check(
    (member_post is null and member_address1 is null and member_address2 is null)
    or
    (member_post is not null and member_address1 is not null and member_address2 is not null)
)
);


-----------------------
-- 시퀀스(sequence)
-----------------------
--번호 자동 생성 도구
--옵션을 통해 생성할 번호의 형태를 지정할 수 있음
--고유번호 생성할 때 많이 사용
--(우리 수업 규칙) 시퀀스 이름은 테이블 이름에 _seq를 추가하여 사용 

drop table pokemon;

create table pokemon(
pokemon_no number(10) primary key,
pokemon_name varchar2(30) not null,
pokemon_type varchar2(9) not null,
check(pokemon_type in ('불', '물', '땅', '바람', '전기', '곤충', '독', '무속성'))
);

--drop sequence pokemon_seq;
create sequence pokemon_seq;


insert into pokemon(pokemon_no, POKEMON_NAME, POKEMON_TYPE)
values(pokemon_seq.nextval,'리자몽','불');

select * from pokemon;

--(Q)기존에 만든 테이블 중에서 시퀀스가 필요하다면 생성한 뒤 데이터 등록
--country, player, menu, item, phone, game_user, lecture

drop table country;
drop table player;
drop table menu;
drop table item;
drop table phone;
drop table game_user;
drop table lecture;

create table country(
country_no number primary key,
country_name varchar2(45) not null unique,
country_capital varchar2(45) not null unique,
country_population number not null,
check(regexp_like(country_name, '^[가-힣]{1,15}$')),
check(country_population > 0)
);
create sequence country_seq;
--create sequence country_seq nocache;

insert into country(country_no, country_name, country_capital, country_population)
values(country_seq.nextval, '한국', '서울', 50000000);
commit;
select * from country;

create table player(
player_no number primary key,--구분을 위해 추가한 항목
player_name varchar2(21) not null,
player_event varchar2(45) not null,
player_type char(6) not null,
player_gold_medal number not null,
player_silver_medal number not null,
player_bronze_medal number not null,
check(regexp_like(player_name, '^[가-힣]{2,7}$')),
--check(player_type in ('동계', '하계')),
check(player_type = '동계' or player_type = '하계'),
check(player_gold_medal >= 0),
check(player_silver_medal >= 0),
check(player_bronze_medal >= 0)
);
create sequence player_seq;
insert into player(
	player_no, player_name, player_event, 
	player_type, player_gold_medal, player_silver_medal, player_bronze_medal
)
values(player_seq.nextval, '진종오', '사격', '동계', 4, 2, 1);
commit;
select * from player;

create table menu(
menu_no number primary key,
menu_name varchar2(60) not null unique,
menu_type varchar2(15) not null,
menu_price number not null,
menu_event char(1) not null,
check(menu_type in ('음료','디저트','아이스크림','식사','케이크')),
check(menu_price >= 0),
check(menu_event in ('Y', 'N'))
);
create sequence menu_seq;
insert into menu(menu_no, menu_name, menu_type, menu_price, menu_event)
values(menu_seq.nextval, '핫아메리카노', '음료', 5000, 'Y');
commit;
select * from menu;

create table item (
item_no number primary key,
item_name varchar2(60) not null,
item_type varchar2(15) not null,
item_price number not null,
item_discount_rate number(3,2),
item_qty number default 0 not null,
item_early char(1) default 'N' not null,
check(item_type in ('식품','잡화','의류','장난감','생필품','스포츠','주방','전자제품')),
check(item_price >= 0),
--check(item_discount_rate >= 0 and item_discount_rate <= 1),
check(item_discount_rate between 0 and 1),
check(item_qty >= 0),
check(item_early in ('Y','N'))
);
create sequence item_seq;
insert into item(item_no, item_name, item_type, item_price)
values(item_seq.nextval, '양파링', '식품', 3000);
commit;
select * from item;

create table phone (
phone_no number primary key,
phone_name varchar2(60) not null,
phone_telecom varchar2(45) not null,
phone_price number not null,
phone_contract number,
check(phone_price >= 0),
check(phone_contract in (24, 30, 36))
);
create sequence phone_seq;
insert into phone(phone_no, phone_name, phone_telecom, phone_price)
values(phone_seq.nextval, '아이폰14pro', 'KT', 1200000);
commit;
select * from phone;

create table game_user (
game_user_no number primary key,
game_user_id varchar2(24) not null unique,
game_user_job varchar2(9) not null,
game_user_level number default 1 not null,
game_user_money number default 0 not null,
check(regexp_like(game_user_id, '^[A-Za-z0-9가-힣]{1,8}$')),
check(game_user_job in ('전사','성직자','도적')),
check(game_user_level > 0),
check(game_user_money >= 0)
);
create sequence game_user_seq;
insert into game_user(game_user_no, game_user_id, game_user_job)
values(game_user_seq.nextval, '테스트2', '전사');
commit;
select * from game_user;

create table lecture (
lecture_no number primary key,
lecture_name varchar2(90) not null,
lecture_category varchar2(30) not null,
lecture_period number not null,
lecture_price number default 0 not null,
lecture_type varchar2(12) default '오프라인' not null,
check(lecture_period > 0),
check(lecture_price >= 0),
check(lecture_type in ('온라인', '오프라인', '혼합'))
);
create sequence lecture_seq;
insert into lecture(lecture_no, lecture_name, lecture_category, lecture_period, lecture_price, lecture_type)
values(lecture_seq.nextval, '자바 프로그래밍', 'IT', 180, 100000, '온라인');
commit;
select * from lecture;

-- 도서 테이블(book)
drop table book;
create table book(
book_id number primary key,
book_title varchar2(300) not null,
book_author varchar2(90),
book_publication_date char(10),
book_price number not null,
book_publisher varchar2(90),
book_page_count number not null,
book_genre varchar2(30) not null,
check(regexp_like(book_author, '^[^!@#$]+$')),
check(regexp_like(book_publication_date, '^([0-9]{4})-((02-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(book_price >= 0),
check(book_page_count > 0)
);

drop sequence book_seq;
create sequence book_seq;
-- 데이터 추가
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '해리포터와 마법사의 돌', 'J.K 롤링', '1997-06-26', 
    15000, '문학동네', 320, '판타지'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '어린왕자', '앙투안 드 생텍쥐페리', '1943-04-06', 
    12000, '열린책들', 130, '소설'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '삼국지', '나관중', '1522-01-01', 
    30000, '민음사', 850, '역사'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '데미안', '헤르만 헤세', '1919-01-01', 
    13000, '더클래식', 200, '소설'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '어린이 교양 과학', '박영규', '2019-07-01', 
    15000, '사계절출판사', 300, '과학'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '조선왕조실록', '한중록', '1922-05-05', 
    45000, '휴머니스트', 500, '역사'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '무궁화 꽃이 피었습니다', '김진명', '1933-11-15', 
    10000, '예문아카이브', 360, '소설'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '토지', '박경리', '1969-01-01', 
    22000, '지식을만드는지식', 700, '소설'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '지적 대화를 위한 넓고 얕은 지식', '채사장', '2014-12-01', 
    17000, '한빛비즈', 450, '교양'
);
insert into book(
    book_id, book_title, book_author, book_publication_date,
    book_price, book_publisher, book_page_count, book_genre
)
values(
    book_seq.nextval, '1984', '조지 오웬', '1949-06-08', 
    14000, '열린책들', 280, '소설'
);
commit;

select * from book;
