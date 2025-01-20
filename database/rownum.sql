select rownum, product.* from product;

select rownum, product.* from product order by price asc;

select rownum, TMP.* from (
	select * from product order by price asc
)TMP;

select rownum, TMP.* from (
	select * from product order by price asc
)TMP where rownum <= 5;

select rownum, TMP.* from (
	select * from product order by price asc
)TMP where rownum between 1 and 10;

select rownum, TMP.* from (
	select * from product order by price asc
)TMP where rownum between 2 and 10; --1 이상이 아니면 안나옴

select * from (
	select rownum rn, TMP.* from (
		select * from product order by price asc
)TMP
)where rn between 6 and 10;

select * from (
	select rownum rn, TMP.* from (
		select * from board order by board_no desc
)TMP
)where rn between 1 and 3;

select * from (
	select rownum rn, TMP.* from (
		select * from pokemon order by pokemon_no asc
)TMP
)where rn between 1 and 3;

-- 게시판의 데이터가 너무 많으니 페이지를 나눠서 보여줍시다
-- 규칙 : 한 페이지당 10개씩 표시
-- 1페이지
select * from (
	select rownum rn, TMP.* from (
		select * from board order by board_no desc
)TMP
)where rn between 1 and 10;

-- 2페이지
select * from (
	select rownum rn, TMP.* from (
		select * from board order by board_no desc
)TMP
)where rn between 11 and 20;

-- 20페이지
select * from (
	select rownum rn, TMP.* from (
		select * from board order by board_no desc
)TMP
)where rn between 191 and 200;

-- n페이지 : (n*10-9)부터 (n*10)까지

--집계함수 : 테이블을 요약해서 한 개의 값을 가져오는 명령들
select max(board_no) from board;
select min(board_no) from board;

select count(board_no) from board;
select count(*) from board; --null도 세지만, PK는 null이 없으므로 위와 동일
