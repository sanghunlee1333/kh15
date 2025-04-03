commit;

-- (회원 삭제)
delete member where member_id = 'user2';
delete member where member_id = 'company1';

-- (회사 삭제)
delete company where company_no = '1';

-- (댓글 삭제)
delete reply where reply_no = '9';

-- (일반회원의 회사이력 삭제)
delete company_history where company_history_no = '1';
delete company_history where company_history_no = '2';
delete company_history where company_history_no = '16';
delete company_history where company_history_no = '17';

SELECT * FROM user_sequences WHERE sequence_name = 'REVIEW_SEQ';

update member set member_company_no = '1' where member_id = 'user1';
update member set member_company_no = '1' where member_id = 'company1';
update member set member_company_no = '1' where member_id = 'user11';

update company_history set company_no = '1' where company_history_no = '1';
