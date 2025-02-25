drop table cert;
create table cert(
cert_email varchar2(60) primary key,
cert_number char(8) not null,
cert_time timestamp default systimestamp not null,
cert_confirm timestamp
);

select * from cert;

select 
	cert_time, 
	extract(day from (systimestamp-cert_time)) days,
	extract(hour from (systimestamp-cert_time)) hours,
	extract(minute from (systimestamp-cert_time)) minutes,
	extract(second from (systimestamp-cert_time)) seconds,
from cert;

delete cert where cert_email in (
	select TMP.cert_email from (
			select 
			cert.*, 
			extract(day from (systimestamp-cert_time)) * 24 * 60 +
			extract(hour from (systimestamp-cert_time)) * 60 + 
			extract(minute from (systimestamp-cert_time)) +
			extract(second from (systimestamp-cert_time)) / 60
			as diff
		from cert
	)TMP 
	where (cert_confirm is null and diff >= 10) 
		or (cert_confirm is not null and diff >= 30); -- (미인증 10분 이상) or (인증 완료 30분 이상)

);
rollback;





