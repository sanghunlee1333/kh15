commit;

-- (회원 삭제)
delete member where member_id = 'user10';
delete member where member_id = 'user11';
delete member where member_id = 'user12';

delete member where member_id = 'greensolution';
delete member where member_id = 'fashiontrend';
delete member where member_id = 'healthcarepro';
delete member where member_id = 'fashionforward';
delete member where member_id = 'foodiesdelight';
delete member where member_id = 'automasters';
delete member where member_id = 'edutechsol';
delete member where member_id = 'travelexplorer';
delete member where member_id = 'financepro';
delete member where member_id = 'creativedesign';
delete member where member_id = 'logisticspro';
delete member where member_id = 'realestateleader';
delete member where member_id = 'entertainworld';
delete member where member_id = 'energysolution';


-- (회사 삭제)
delete company where company_no = '1';

-- (댓글 삭제)
delete reply where reply_no = '9';

-- (일반회원의 회사이력 삭제)
delete company_history where company_history_no = '1';
delete company_history where company_history_no = '2';
delete company_history where company_history_no = '16';
delete company_history where company_history_no = '17';

delete company_image where attachment_no = '4' and company_no = '14';

insert into company_image (attachment_no, company_no) values ('2' ,'7');
insert into company_image (attachment_no, company_no) values ('3' ,'8');
insert into company_image (attachment_no, company_no) values ('4' ,'9');
insert into company_image (attachment_no, company_no) values ('5' ,'10');
insert into company_image (attachment_no, company_no) values ('6' ,'11');
insert into company_image (attachment_no, company_no) values ('2' ,'12');
insert into company_image (attachment_no, company_no) values ('3' ,'13');
insert into company_image (attachment_no, company_no) values ('4' ,'14');


-- (첨부파일 삭제)
delete attachment where attachment_no = '15';
delete attachment where attachment_no = '18';
delete attachment where attachment_no = '20';
delete attachment where attachment_no = '21';
delete attachment where attachment_no = '22';
delete attachment where attachment_no = '23';
delete attachment where attachment_no = '24';
delete attachment where attachment_no = '25';
delete attachment where attachment_no = '26';

update member set member_company_no = '1' where member_id = 'user1';
update member set member_company_no = '1' where member_id = 'company1';
update member set member_company_no = '1' where member_id = 'user11';

update company_history set company_no = '1' where company_history_no = '1';
