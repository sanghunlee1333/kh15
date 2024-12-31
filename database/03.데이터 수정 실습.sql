-----------------------
-- 데이터 수정(update)
-----------------------
-- 기존에 저장되어 있는 데이터를 변경하는 작업
-- update 테이블 이름 set 변경코드 [where 조건];
-- 조건은 사실 상 무조건 쓴다

-- (ex) 모든 상품의 가격은 0원으로 변경
update product set price = 0;

-- (ex) 모든 상품의 종류를 과자로, 가격은 100원으로 변경
-- and, or는 where에서 조건 합성 시 사용!
update product set type = '과자', price = 100;

-- (ex) 1번 상품의 가격을 1000원으로 변경 (가장 일반적인 형태)
update product set price = 1000 where no = 1;
-- 실행 창에 Updated Rows = 0 이면 실행은 되었어도 적용된 구문이 없다는 뜻
-- update product set price = 1000 where no = 9999;

-- (Q)7번 상품의 이름을 '처음처럼', 가격을 1200원, 분류를 '주류'로 변경
update product set name = '처음처럼', price = 1200, type = '주류' where no = 7;
-- (Q)분류가 '과자'인 상품 가격을 200원 할인
update product set price = price - 200 where type = '과자';
-- (Q)분류가 '아이스크림'인 상품 가격을 10% 인상
update product set price = price * 110/100 where type = '아이스크림';
-- (hint) 오라클에는 복합대입 연산이 없습니다 

select * from product;
rollback;
