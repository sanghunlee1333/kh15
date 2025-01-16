-- 오라클 포트를 변경하는 명령
call dbms_xdb.sethttpport(9090);

-- 현재 오라클 포트를 확인하는 명령
select dbms_xdb.gethttpport() from dual;
