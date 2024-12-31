-----------------------
-- 데이터 조회
-----------------------
--목적에 맞는 데이터를 찾는것
-- SELECT 항목 FROM 테이블 [조건][정렬];

-- [1] 원하는 항목만 조회할 수 있다
select book_title from book;
select book_price from book;
select book_title, book_price from book;
select * from book; --와일드카드(*)는 전체를 의미
--(Q) 한 페이지당 가격을 추가해서 조회
select book_title, book_price/book_page_count from book;
-- 별칭을 추가할 수 있다(쌍따옴표를 쓰면 띄어쓰기 가능하지만 의미가 없음)
select book_title "도서명", book_price/book_page_count "페이지당가격" from book; 
select book_title 도서명, book_price/book_page_count 페이지당가격 from book; --띄어쓰기 하면 코드간 경계가 애매해져서 에러
--(Q) 책의 모든 정보를 조회하며 페이지당 가격을 추가로 계산해서 조회
select book.*, book_price/book_page_count 페이지당가격 from book;

-- [2] 조회에는 필터링 조건을 추가하여 원하는 항목만 가져올 수 있다

-- 숫자와 관련된 조건
-- (ex)book_id가 7인 도서를 조회 (* 비교 연산 중 같다는 자바와 표현방식이 다름)
select * from book where book_id = 7;
-- (ex)가격이 2만원 이하인 도서를 조회
select * from book where book_price <= 20000;
-- (ex)가격이 1만원대인 도서를 조회
select * from book where book_price >= 10000 AND book_price < 20000;
--select * from book where book_price between 10000 AND 19999;

-- 문자와 관련된 조건
-- (ex)제목이 어린왕자인 도서를 조회
select * from book where book_title = '어린왕자';
-- (ex)출판사가 '열린책들'인 도서를 조회
select * from book where book_publisher = '열린책들';
-- (ex)'마법사'가 제목에 포함된 도서를 조회 
-- instr은 위치를 찾는 명령이며, 위치는 1부터 시작 (0이면 없다는 뜻) (강의 다시)
-- like는 패턴을 찾는 연산자이며, %는 글자가 있어도 그만 없어도 그만이라는 뜻
-- regexp_like는 정규표현식 검사 명령이며, 패턴에 의해서 감지
-- instr이 전반적으로 우수한 성능을 보이지만, 상황에 따라 다른 명령도 사용
select * from book where instr(book_title, '마법사') > 0; --평균적으로 빠름 (자바의 indexOf) -- = 1;은 시작이 마법사로 시작하는지 검사
select * from book where book_title like '%마법사%'; --평균적으로 느림 (자바의 contains)
select * from book where regexp_like(book_title, '마법사'); --평균적으로 느림

-- (중요) 시작 검사만큼은 like가 압도적으로 빠르다
select * from book where book_title like '해리포터%'; --매우빠름
select * from book where instr(book_title, '해리포터') = 1; --보통

-- (ex) 제목이 숫자/한글로만 이루어진 도서를 조회
select * from book where regexp_like(book_title, '^[0-9]+$');
select * from book where regexp_like(book_title, '^[가-힣]+$');

-- 날짜와 관련된 조건
-- date, timstamp는 변환이 필요 없음
-- 문자열인데 날짜가 들어있는 경우는 date나 timestamp로 바꿔서 사용 가능
-- to_date() 또는 to_timestamp() 사용
-- to_timestamp(항목, 형식)으로 날짜형식의 문자열을 변환할 수 있다
-- 형식에 대소문자는 의미가 없으며, 다음과 같은 기호가 사용
-- Y(연도), M(월). D(일), H(12시간), HH24(24시간), MI(분) ,SS(초)

-- (ex) 2000년 이후에 출판된 도서를 조회
-- extract는 날짜에서 원하는 항목을 추출하는 명령(year, month, ...)
select * from book where extract(year from to_timestamp(book_publication_date, 'YYYY-MM-DD')) >= 2000;

-- (Q) 여름 (6, 7, 8월)에 출판된 도서를 조회
select * from book where extract(month from to_timestamp(book_publication_date, 'YYYY-MM-DD')) in (6, 7, 8);
select * from book where extract(month from to_timestamp(book_publication_date, 'YYYY-MM-DD')) between 6 and 8;

-- 특정 기간에 출판된 도서를 조회(두 개의 날짜 사이에 위치한 데이터)
-- (ex) 2010년 1월 1일부터 2020년 12월 31일까지
select * from book 
where to_timestamp(BOOK_PUBLICATION_DATE, 'YYYY-MM-DD') 
	between to_timestamp('2010-01-01','YYYY-MM-DD') 
	and to_timestamp('2020-12-31', 'YYYY-MM-DD'); 

-- 만약 시간까지 고려해야 한다면
select * from book 
where to_timestamp(BOOK_PUBLICATION_DATE, 'YYYY-MM-DD') 
  between 
	to_timestamp('2010-01-01' || '00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
	and 
	to_timestamp('2020-12-31' || '23:59:59', 'YYYY-MM-DD HH24:MI:SS'); 

-- [3] 조회를 마친 데이터를 원하는 순서로 정렬할 수 있다

-- (ex) 모든 도서 정보를 도서번호 순으로 조회 (book_id ascending)
select * from book order by book_id; --안쓰면 asc (권장X)
select * from book order by book_id asc;
select * from book order by book_id desc;

--(Q)모든 도서 정보를 가격이 낮은 순으로 조회 (같으면 번호순)
select * from book order by book_price asc;
select * from book order by book_price asc, book_id asc;
select * from book order by book_price desc;

-- (ex) 조건이랑 같이 사용할 수 있다(단, 정렬은 제일 마지막에 해야한다)
--select * from book order by book_price asc where book_price <= 30000; --가구가 들어오지도 않았는데 정리하는 것
select * from book where book_price <= 30000 order by book_price asc, book_id asc;

-- (Q) 도서를 최근 출판한 순서대로 조회 (단, 같으면 도서번호 순)
select * from book order by to_timestamp(BOOK_PUBLICATION_DATE, 'YYYY-MM-DD') desc, book_id asc;

drop table product;
create table product(
no number primary key,
name varchar2(30) not null,
type varchar2(15) check(type in ('과자','아이스크림','주류','사탕','초콜릿')),
price number,
made timestamp,
expire timestamp
);

INSERT INTO product VALUES (1, '스크류바', '아이스크림', 1200, TO_TIMESTAMP('2022-05-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-10-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (2, '마이쮸', '사탕', 900, TO_TIMESTAMP('2022-01-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-01-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (3, '초코파이', '과자', 3000, TO_TIMESTAMP('2022-01-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-01-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (4, '맛동산', '과자', 2200, TO_TIMESTAMP('2022-02-01 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-10-20 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (5, '참이슬', '주류', 1000, TO_TIMESTAMP('2022-01-05 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-04-05 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (6, '처음처럼', '주류', 1000, TO_TIMESTAMP('2022-03-15 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-08-15 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (7, '바나나킥', '과자', 1500, TO_TIMESTAMP('2022-05-03 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-06-03 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (8, '빠삐코', '아이스크림', 1000, TO_TIMESTAMP('2023-12-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-06-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (9, '멘토스', '사탕', 1200, TO_TIMESTAMP('2023-03-20 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-12-31 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (10, '오레오', '과자', 2100, TO_TIMESTAMP('2023-06-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-06-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (11, '포카칩', '과자', 1500, TO_TIMESTAMP('2022-05-05 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-05-05 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (12, '칸쵸', '과자', 1000, TO_TIMESTAMP('2022-06-10 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-06-10 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (13, '허니버터칩', '과자', 1700, TO_TIMESTAMP('2022-07-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-07-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (14, '새우깡', '과자', 1200, TO_TIMESTAMP('2022-08-01 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-08-01 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (15, '칙촉', '과자', 2500, TO_TIMESTAMP('2022-09-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-09-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (16, '가나초콜릿', '초콜릿', 2000, TO_TIMESTAMP('2022-10-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-10-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (17, '빼빼로', '과자', 1500, TO_TIMESTAMP('2022-11-11 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-11-11 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (18, '파이리', '사탕', 1000, TO_TIMESTAMP('2022-12-31 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-12-01 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (19, '초코송이', '과자', 1200, TO_TIMESTAMP('2023-01-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (20, '빈츠', '과자', 1300, TO_TIMESTAMP('2023-02-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-02-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (21, '죠리퐁', '과자', 1400, TO_TIMESTAMP('2023-03-01 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-03-01 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (22, '오징어집', '과자', 1500, TO_TIMESTAMP('2023-04-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-04-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (23, '누네띠네', '과자', 1200, TO_TIMESTAMP('2023-05-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-05-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (24, '포테토칩', '과자', 1600, TO_TIMESTAMP('2023-06-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-06-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (25, '새콤달콤', '사탕', 1000, TO_TIMESTAMP('2023-07-01 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-07-01 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (26, '카라멜콘', '과자', 1100, TO_TIMESTAMP('2023-08-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-08-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO product VALUES (27, '오징어땅콩', '과자', 1500, TO_TIMESTAMP('2023-09-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-09-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));


commit;
--등록된 상품의 이름만 조회
select name from product;
--등록된 상품의 이름과 가격을 조회
select name, price from product;
-- 등록된 상품의 모든 정보를 조회
select * from product; --select product.* from product;
-- 등록된 상품의 모든 정보와 유통기간(제조일부터 폐기일 사이의 구간)
select product.*, expire - made 유통기간 from product;
-- 가격이 2000원 이상인 상품만 조회
select * from product where price >= 2000;
-- 가격이 2000원 이상 3000원 이하인 상품만 조회
select * from product where price >= 2000 and price <= 3000;
-- select * from product where price between 2000 and 3000;
-- 25번 상품을 조회
select * from product where no = 25;
-- 이름이 스크류바인 상품을 조회
select * from product where name = '스크류바';
-- 이름이 참으로 시작하는 상품을 조회
select * from product where name like '참%';
-- select * from product where instr(name, '참') = 1;
-- select * from product where regexp_like(name, '^참");
-- 이름에 이가 포함된 상품을 조회
select * from product where instr (name, '이') > 0;
-- select * from product where name like '%이%';
-- select * from product where regexp_like(name, '이');
-- 제조년도가 2022년인 상품을 조회
select * from product where extract (year from made) = 2022;
-- select * from product where to_char(made, 'YYYY') = '2022'; --문자열로 변경하는 방식
-- select * from product where made between to_timestamp('2022-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
-- and to_timestamp('2022-12-31 23:59:59', 'YYYY-MM-DD' HH24:MI:SS); -- 범용성이 제일 좋은 방식
-- 2020년 1월 1일부터 현재까지 제조된 상품을 조회
-- date면 sysdate, timestamp면 systimestamp가 현재 ㅣ각
select * from product
where made
  between 
	to_timestamp('2020-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS') 
	and 
	systimestamp;
-- 2020년 상반기(6월 30일까지) 제조상품을 조회
select * from product
where extract(year from made) = 2020 
	and extract(month from made) between 1 and 6;
select * from PRODUCT
-- 더 좋은 방식
where made
  between 
	to_timestamp('2020-01-01', 'YYYY-MM-DD HH24:MI:SS') 
	and 
	to_timestamp('2020-06-30', 'YYYY-MM-DD HH24:MI:SS');
-- 모든 상품을 가격이 낮은 순으로 조회
-- price가 유니크였으면 primary key 정렬이 필요 없다. 겹칠 일이 없기 때문
select * from product order by price asc, no asc;
-- 모든 상품을 최근 제조한 순으로 조회
select * from product order by made desc, no asc;
-- 가격이 2000원 이상인 상품을 1차 이름순, 2차 제조일순으로 조회
select * from product where price >= 2000 order by name asc, made asc, no asc;

