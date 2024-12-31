-----------------------
-- 데이터 삭제 (delete)
-----------------------
-- 이미 저장되어 있는 데이터를 지우는 작업(commit/rollback의 영향 받음)
-- delete [from] 테이블 [where 조건];

-- (ex)모든 데이터 삭제
delete product;
--delete from product;

-- (ex)11번 상품 삭제 (PK에 의한 삭제)
delete product where no = 11;

select * from product;
rollback;
