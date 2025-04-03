drop table client;
create table client (
	client_id varchar2(20) primary key,
	client_pw varchar2(30) not null,
	client_name varchar2(15) not null
);

insert into client(client_id, client_pw, client_name) values('test', 'Password', '테스트');
