commit;

-- 관리자용 더미 데이터
INSERT INTO member (
    member_id,
    member_pw,
    member_type,
    member_name
) VALUES (
    'admin01', -- 관리자 아이디
    'Admin123!', -- 관리자 비밀번호
    '관리자',       -- 회원 유형: 관리자
    '관리자'         -- 관리자 이름
);

-- 사업자등록번호 더미데이터 (형식: 000-00-00000)  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('123-45-67890', '주식회사 기술혁신', TIMESTAMP '2015-03-01 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('234-56-78901', '(주)녹색솔루션', TIMESTAMP '2018-07-15 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('345-67-89012', '헬스케어프로 의료법인', TIMESTAMP '2010-11-22 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('456-78-90123', '패션포워드 주식회사', TIMESTAMP '2019-05-10 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('567-89-01234', '푸디즐라이트 푸드', TIMESTAMP '2012-09-30 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('678-90-12345', '오토마스터즈 자동차', TIMESTAMP '2005-12-12 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('789-01-23456', '에듀테크솔루션 교육그룹', TIMESTAMP '2017-04-18 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('890-12-34567', '여행탐험가 트래블', TIMESTAMP '2014-08-25 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('901-23-45678', '재무전문가 파이낸스', TIMESTAMP '2008-02-14 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('012-34-56789', '크리에이티브디자인 스튜디오', TIMESTAMP '2016-06-05 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('987-65-43210', '물류전문가 로지스틱스', TIMESTAMP '2013-10-20 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('876-54-32109', '부동산리더 공인중개사', TIMESTAMP '2009-01-07 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('765-43-21098', '엔터테인먼트월드 미디어', TIMESTAMP '2011-07-19 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('654-32-10987', '에너지솔루션 주식회사', TIMESTAMP '2015-09-28 00:00:00', 'Y');  
INSERT INTO business_number (bn_cr_number, bn_company_name, bn_registration_date, bn_is_valid) VALUES ('543-21-09876', '패션트렌드 디자인룸', TIMESTAMP '2017-12-03 00:00:00', 'Y');


-- 기업 등록 더미데이터
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (1, '주식회사 기술혁신', 'http://techinnovators.co.kr', '0212345678', '개발', '백엔드 개발', '12345', '서울특별시 강남구 역삼동', '123번지', '123-45-67890');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (2, '(주)녹색솔루션', 'https://greensolution.co.kr', '0223456789', '환경/안전/보건(ESH)', '환경/안전/보건(ESH)', '23456', '경기도 성남시 분당구', '456번지', '234-56-78901');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (3, '헬스케어프로 의료법인', 'http://healthcarepro.co.kr', '0234567890', '의약', ' 의사', '34567', '대구광역시 중구 동인동', '789번지', '345-67-89012');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (4, '패션포워드 주식회사', 'https://fashionforward.co.kr', '0245678901', '디자인', '패션/섬유 디자인', '45678', '부산광역시 해운대구', '101번지', '456-78-90123');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (5, '푸디즐라이트 푸드', 'http://foodiesdelight.co.kr', '0256789012', '식품/제약', '식품/제약', '56789', '인천광역시 남동구', '202번지', '567-89-01234');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (6, '오토마스터즈 자동차', 'https://automasters.co.kr', '0267890123', '생산/제조', '생산/제조', '67890', '울산광역시 남구', '303번지', '678-90-12345');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (7, '에듀테크솔루션 교육그룹', 'http://edutechsolutions.co.kr', '0278901234', '교육', '교육기획/교재개발', '78901', '광주광역시 서구', '404번지', '789-01-23456');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (8, '여행탐험가 트래블', 'https://travelexplorers.co.kr', '0289012345', '서비스/고객지원', '여행가이드', '89012', '제주특별자치도 제주시', '505번지', '890-12-34567');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (9, '재무전문가 파이낸스', 'http://financepro.co.kr', '0290123456', '금융/재무', '재무기획/재무분석', '90123', '대전광역시 서구', '606번지', '901-23-45678');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (10, '크리에이티브디자인 스튜디오', 'https://creativedesign.co.kr', '0211234567', '디자인', '그래픽 디자인', '01234', '경상북도 포항시', '707번지', '012-34-56789');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (11, '물류전문가 로지스틱스', 'http://logisticspro.co.kr', '0222345678', '유통/무역', '물류/유통/운송', '12345', '경상남도 창원시', '808번지', '987-65-43210');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (12, '부동산리더 공인중개사', 'https://realestateleader.co.kr', '0233456789', '부동산/공인중개사', '부동산/공인중개사', '23456', '충청북도 청주시', '909번지', '876-54-32109');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (13, '엔터테인먼트월드 미디어', 'http://entertainmentworld.co.kr', '0244567890', '미디어/홍보', '홍보', '34567', '전라북도 전주시', '1010번지', '765-43-21098');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (14, '에너지솔루션 주식회사', 'https://energysolution.co.kr', '0255678901', '화학/에너지', '화학/에너지', '45678', '충청남도 천안시', '1111번지', '654-32-10987');  
INSERT INTO company (company_no, company_name, company_url, company_contact, company_industry, company_job, company_post, company_address1, company_address2, company_cr_number) VALUES (15, '패션트렌드 디자인룸', 'http://fashiontrend.co.kr', '0266789012', '디자인', '패션/섬유 디자인', '56789', '전라남도 광주시', '1212번지', '543-21-09876');

-- (일반회원의 회사이력 - 더미데이터) -> company_no는 company 테이블을 참고하여 실제있는 company
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (1, '901212-1234567', 1, DATE '2016-05-12', DATE '2020-08-30');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (2, '950304-2345678', 2, DATE '2019-09-01', NULL);  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (3, '880715-1122334', 3, DATE '2012-03-15', DATE '2015-12-31');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (4, '920801-2987654', 4, DATE '2020-11-10', DATE '2023-01-15');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (5, '930505-1567890', 5, DATE '2013-12-20', DATE '2018-06-20');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (6, '871022-2456789', 6, DATE '2008-07-22', NULL);  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (7, '910303-1789456', 7, DATE '2018-02-14', DATE '2022-05-05');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (8, '940606-2123456', 8, DATE '2015-10-30', DATE '2019-04-10');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (9, '891212-1678901', 9, DATE '2009-04-05', DATE '2014-08-22');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (10, '900909-2567890', 10, DATE '2017-08-17', NULL);  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (11, '931111-1456789', 11, DATE '2014-03-10', DATE '2017-11-30');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (12, '870505-2234567', 12, DATE '2010-12-01', DATE '2013-09-15');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (13, '920202-1987654', 13, DATE '2013-05-20', DATE '2016-02-28');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (14, '950707-1345678', 14, DATE '2016-11-15', NULL);  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (15, '960808-2765432', 15, DATE '2018-06-25', DATE '2021-07-10');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (16, '890101-1567890', 1, DATE '2017-09-12', DATE '2020-03-25');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (17, '930404-2876543', 2, DATE '2021-02-28', NULL);  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (18, '910707-1678901', 3, DATE '2014-07-18', DATE '2018-09-30');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (19, '940303-2456789', 4, DATE '2022-01-05', DATE '2023-12-01');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (20, '950808-1987654', 5, DATE '2015-04-22', DATE '2019-10-10');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (21, '880202-2123456', 6, DATE '2010-08-30', NULL);  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (22, '900606-1765432', 7, DATE '2019-03-15', DATE '2022-11-20');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (23, '920909-2987654', 8, DATE '2016-12-10', DATE '2020-07-05');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (24, '930101-1567890', 9, DATE '2011-06-20', DATE '2014-04-15');  
INSERT INTO company_history (company_history_no, member_id_card_num, company_no, company_history_join_date, company_history_leave_date) VALUES (25, '960505-2345678', 10, DATE '2017-08-17', NULL);

-- 더미 데이터 생성
INSERT INTO review (review_no, review_writer, review_company_no, review_score, review_comment, review_like, review_wtime, review_etime, review_strength, review_weakness, review_salary, review_work_and_life, review_promotion, review_culture, review_director) VALUES (100, 'user5', 2, 4, '좋은 회사입니다.', 10, SYSTIMESTAMP, SYSTIMESTAMP, '급여가 높습니다.', '야근이 잦습니다.', 4, 3, 2, 5, 4);
