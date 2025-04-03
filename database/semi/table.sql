ROLLBACK;
COMMIT;

-- 테이블 삭제
DROP TABLE member;
DROP TABLE company;
DROP TABLE business_number;
DROP TABLE review cascade constraint;
DROP TABLE COMPANY_IMAGE;
DROP TABLE attachment;
DROP TABLE reply cascade constraint;
DROP TABLE company_history;

-- 시퀀스 삭제 및 생성
drop sequence company_seq;
drop sequence review_seq;
drop sequence attachment_seq;
drop sequence reply_seq;
drop sequence company_history_no;

create sequence company_seq;
create sequence review_seq;
create sequence attachment_seq;
create sequence reply_seq;
create sequence company_history_no;

-- 회원 테이블
CREATE TABLE member (
    member_id VARCHAR2(20) PRIMARY KEY,
    member_pw VARCHAR2(16) NOT NULL,
    member_type VARCHAR2(12) NOT NULL,  -- '일반회원', '기업회원', '관리자' 등으로 구분
    member_name VARCHAR2(15) NOT NULL,
    member_id_card_num VARCHAR2(14),    -- 주민등록번호 컬럼 추가
    member_contact CHAR(11),
    member_email VARCHAR2(60),
    member_post VARCHAR2(6),
    member_address1 VARCHAR2(300),
    member_address2 VARCHAR2(300),
    member_join TIMESTAMP DEFAULT SYSTIMESTAMP,
    member_login TIMESTAMP,
    member_change TIMESTAMP,
    member_industry VARCHAR2(45),  -- 산업 (개인회원-선택, 기업회원-필수)
    member_job VARCHAR2(45),  -- 직종 (개인회원-선택, 기업회원-필수)
    member_position VARCHAR2(15),  -- 직책 (기업회원-필수)
    member_cr_number VARCHAR2(12), -- 사업자 등록번호(외래키)(기업회원)
    member_company_no NUMBER REFERENCES company(company_no) ON DELETE SET NULL,  -- 기업 번호(외래키)
    CONSTRAINT fk_member_cr_number FOREIGN KEY (member_cr_number) REFERENCES business_number(bn_cr_number),
    CONSTRAINT unq_member_cr_number UNIQUE (member_cr_number), -- 사업자등록번호 유니크 제약 조건 추가
    CONSTRAINT chk_member_type CHECK (
        member_type IN ('일반회원', '기업회원', '관리자') AND --member_type이 '일반회원', '기업회원', '관리자' 중 하나
    	(member_type != '기업회원' OR -- 일반회원과 관리자의 경우 아래 필드들에 대해 제약(X)
     	(member_industry IS NOT NULL AND member_job IS NOT NULL AND member_position IS NOT NULL)) -- 기업회원인 경우에만 industry, job, position이 NULL이 아니어야 함을 확인
	),
	CONSTRAINT chk_member_id_card_num CHECK (
    (member_type = '일반회원' AND member_id_card_num IS NOT NULL) OR
    (member_type != '일반회원')
	),
	CONSTRAINT unq_member_id_card_num UNIQUE (member_id_card_num),
    CONSTRAINT chk_member_id_card_num_format CHECK (
        member_id_card_num IS NULL OR -- NULL 허용
        REGEXP_LIKE(member_id_card_num, '^[0-9]{6}-[0-9]{7}$') -- 주민등록번호 형식 검사
    ),
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
check(regexp_like(member_contact, '^010[1-9][0-9]{7}$')),
check(member_type in ('일반회원', '기업회원', '관리자')),
check(regexp_like(member_post, '^[0-9]{5,6}$')),
-- 셋다 없는/있는 경우
check(
    (member_post is null and member_address1 is null and member_address2 is null)
    or
    (member_post is not null and member_address1 is not null and member_address2 is not null)
)
);


-- (참고)기업회원 가입 시:
-- 입력받은 사업자등록번호가 business_number 테이블에 있는지 확인.
-- 있다면, 해당 사업자등록번호로 company 테이블을 조회.
-- company 테이블에 해당 정보가 있다면, 그 company_no를 member 테이블의 member_company_no에 설정.
-- 없다면, member_company_no는 NULL로 설정.

-- 기업 테이블
CREATE TABLE company (
    company_no NUMBER PRIMARY KEY,
    company_name VARCHAR2(45) NOT NULL,
    company_url VARCHAR2(60),
    company_contact CHAR(11),
    company_industry VARCHAR2(45) NOT NULL,
    company_job VARCHAR2(45) NOT NULL,
    company_post VARCHAR2(6) NOT NULL,
    company_address1 VARCHAR2(300) NOT NULL,
    company_address2 VARCHAR2(300) NOT NULL,
    company_cr_number VARCHAR2(12) NOT NULL UNIQUE,
    check(regexp_like(company_url, '^(http:\/\/www\.|https:\/\/www\.|http:\/\/|https:\/\/)?[a-zA-Z0-9]+([\-\.]{1}[a-zA-Z0-9]+)*\.[a-zA-Z]{2,5}(:[0-9]{1,5})?(\/.*)?$')),
    CONSTRAINT fk_company_name_cr_number 
        FOREIGN KEY (company_name, company_cr_number) --복합 외래키로 설정
        REFERENCES business_number(bn_company_name, bn_cr_number) --데이터를 삽입 시, company_name과 company_cr_number가 business_number 테이블의 것들과 정확히 일치해야 함
);

-- 사업자등록번호 테이블 (더미 데이터)
CREATE TABLE business_number (
    bn_cr_number VARCHAR2(12) NOT NULL UNIQUE,
    bn_company_name VARCHAR2(100) NOT NULL,
    bn_registration_date TIMESTAMP DEFAULT SYSTIMESTAMP,
    bn_is_valid CHAR(1) DEFAULT 'Y' CHECK (bn_is_valid IN ('Y', 'N')),
    CONSTRAINT pk_business_number PRIMARY KEY (bn_cr_number, bn_company_name)
);

-- 리뷰 테이블
CREATE TABLE review (
    review_no NUMBER PRIMARY KEY, --리뷰번호
    review_writer REFERENCES member(member_id) ON DELETE SET NULL, --아이디
    review_company_no NUMBER REFERENCES company(company_no) ON DELETE SET NULL, -- 회사번호 (추가됨)
    review_score NUMBER not null, --리뷰평점
    review_comment VARCHAR2(300) NOT null, --리뷰 한줄평
    review_like NUMBER DEFAULT 0, --리뷰 좋아요
    review_wtime TIMESTAMP default SYSTIMESTAMP not null, --작성일
    review_etime TIMESTAMP, -- 수정일
    review_strength VARCHAR2(3000) not null, --기업 장점
    review_weakness VARCHAR2(3000) not null, --기업 단점
    review_salary NUMBER not null, --급여 만족도(별점)
    review_work_and_life NUMBER not null, --워라벨 만족도(별점)
    review_promotion NUMBER not null, --승진기회 만족도(별점)
    review_culture NUMBER not null, --사내문화 만족도(별점)
    review_director NUMBER not null, --경영진 만족도(별점)
    check(review_like >= 0),
    check(review_salary >= 0),
    check(review_work_and_life >= 0),
    check(review_promotion >= 0),
    check(review_culture >= 0),
    check(review_director >= 0),
    check(review_score >= 0)
);

-- 기업 이미지 테이블
CREATE TABLE company_image (
    attachment_no references attachment(attachment_no) on delete cascade,
    company_no references company(company_no) on delete set null
);

-- 첨부파일 테이블
create table attachment(
    attachment_no number primary key,
    attachment_name varchar2(255) not null,
    attachment_type varchar2(255) not null,
    attachment_size number not null
    check(attachment_size >= 0)
);

-- 댓글 테이블
CREATE TABLE reply (
    reply_no NUMBER PRIMARY KEY,
    reply_writer VARCHAR2(50) REFERENCES member(member_id) ON DELETE SET NULL,
    reply_origin NUMBER REFERENCES review(review_no) ON DELETE CASCADE,
    reply_content VARCHAR2(1500),
    reply_wtime TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
    reply_etime TIMESTAMP,
    company_no NUMBER REFERENCES company(company_no) ON DELETE CASCADE
);

-- 회사 이력 (일반회원) (더미데이터)
CREATE TABLE company_history (
    company_history_no NUMBER PRIMARY KEY,
    member_id_card_num VARCHAR2(14),  -- 외래 키 제약 조건 제거
    company_no NUMBER REFERENCES company(company_no) on delete set null,
    company_history_join_date DATE,
    company_history_leave_date DATE
);

CREATE OR REPLACE VIEW review_list_view AS
SELECT
    R.review_no,
    R.review_writer,
    R.review_company_no,
    R.review_score,
    R.review_comment,
    R.review_wtime,
    R.review_etime,
    R.review_like,
    R.review_salary,
    R.review_work_and_life, 
    R.review_promotion,
    R.review_culture, 
    R.review_director,
    M.member_name,
    M.member_industry,
    M.member_job
FROM
    review R
LEFT OUTER JOIN
    member M ON R.review_writer = M.member_id;
