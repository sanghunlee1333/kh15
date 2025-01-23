-- 상품권 테이블
drop table giftcard cascade constraint;
create table giftcard (
giftcard_no number primary key,
giftcard_name varchar2(90) not null,
giftcard_content varchar2(1000) not null,
giftcard_charge number not null,
giftcard_price number not null,
check(giftcard_charge > 0),
check(giftcard_price >= 0)
);

drop sequence giftcard_seq;
create sequence giftcard_seq;

-- 상품권 이미지 테이블
drop table giftcard_image cascade constraint;
create table giftcard_image(
giftcard_no references giftcard(giftcard_no) on delete cascade,
attachment_no references attachment(attachment_no) on delete cascade
);

-- 상품권 구매이력 테이블
drop table giftcard_purchase cascade constraint;
create table giftcard_purchase(
giftcard_purchase_no number primary key,
giftcard_purchase_target references giftcard(giftcard_no) on delete cascade,
giftcard_purchase_member varchar2(20) not null,--원래 외래키여야 하지만 회원이 탈퇴한다고 사라지거나 비워지면 안되므로 일반 항목처럼 설정
giftcard_purchase_qty number default 1 not null,
giftcard_purchase_time timestamp default systimestamp not null,
check(giftcard_purchase_qty > 0)
);

drop sequence giftcard_purchase_seq;
create sequence giftcard_purchase_seq;
