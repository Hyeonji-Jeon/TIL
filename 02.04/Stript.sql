select now();
# 2025-02-03 14:18:36.000
CREATE TABLE tbl_todo (
   tno INT AUTO_INCREMENT PRIMARY KEY,
   title VARCHAR(100) NOT NULL,
   writer VARCHAR(50) NOT NULL,
   regDate	timestamp default now(),
   modDate timestamp default now()
)
;
insert into tbl_todo (title,writer) values ('Test','user00')
;
#재귀 복사
insert into tbl_todo (title,writer) select title, writer from tbl_todo;
select * from tbl_todo
;
select count(*) from tbl_todo;
drop table tbl_todo
;

