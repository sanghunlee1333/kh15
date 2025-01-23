-- 집계 함수와 그룹화

-- [1] 포켓몬스터 속성을 출력
select pokemon_type from pokemon;

-- [2-1] 중복을 제거
select DISTINCT pokemon_type from pokemon;

-- [2-2] 그룹을 구성
select pokemon_type from pokemon group by POKEMON_TYPE;

-- 그룹별 개체수 출력
select pokemon_type, count(*) from pokemon group by POKEMON_TYPE;
select pokemon_type key, count(*) value from pokemon group by POKEMON_TYPE;

-- (Q) Player 테이블에서 동계와 하계별 선수 인원수를 출력
select player_type, count(*) from player group by PLAYER_TYPE;
select player_type key, count(*) value from player group by PLAYER_TYPE;

-- (Q) Player 테이블에서 종목별 선수 인원수를 출력
select player_EVENT, count(*) from player group by PLAYER_EVENT;
select player_EVENT key, count(*) value from player group by PLAYER_EVENT;

-- (Q) Player 테이블에서 종목별 선수의 금메달 수 합계 출력
select player_event, sum(player_gold_medal) from player group by player_event;
select player_event key, sum(player_gold_medal) value from player group by player_event;

-- (Q) Player 테이블에서 종목별 선수의 전체 메달 수 합계 출력
select player_event key, sum(player_gold_medal + player_silver_medal + player_bronze_medal) value from player group by player_event;

-- (Q) 상품(product)별 평균가격과 가지수를 출력
select type key, avg(price), count(*) from product group by type;

-- (Q) 상품(product)별 평균가격과 가지수를 출력 (단, 상품이 3개 이상인 그룹만)
-- 그룹과 관련된 조건은 having 구문을 사용
select type key, avg(price), count(*) from product group by type having count(*) > 3;
