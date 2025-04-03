SELECT sid, serial#, username, program, status FROM v$session WHERE username IS NOT NULL;

SELECT   /*+ rule */
        s.username,
        decode(locks.locked_mode, 1, NULL, 2, '행 공유(row share)', 3, '행 배타적(row exclusive)', 4, '공유 테이블(share table)', 5, '공유 행 배타적(share row exclusive)', 6, '배타적(exclusive)') mode_held,
        o.object_name,
        locks.session_id,
        s.serial#,
        s.logon_time
FROM     v$locked_object locks, dba_objects o, v$session s
WHERE    locks.object_id = o.object_id AND locks.session_id = s.sid
ORDER BY object_name;

ALTER SYSTEM KILL SESSION '65,1241';

grant create view to kh15s1;
commit;
