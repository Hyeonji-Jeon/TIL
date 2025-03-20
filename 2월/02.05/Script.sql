select now();

# 2025-02-03 14:56:11.000

select * from todo t;


CREATE TABLE tbl_todo (

	tno INT AUTO_INCREMENT PRIMARY KEY ,
	title VARCHAR(100) NOT NULL,
	writer VARCHAR(50) NOT null,
	regDate timestamp default now(),
	modDate timestamp default now()

)
;

insert into tbl_todo (title,writer) values ('test','user01')
;

# 재귀 복사
insert into tbl_todo (title,writer) select title, writer from tbl_todo;

select
	tno, title, writer, regdate
from
	tbl_todo
where
	tno > 0
order by
	tno desc
limit 10 OFFSET 0
;

select count(*) from tbl_todo;

drop table tbl_todo 
;