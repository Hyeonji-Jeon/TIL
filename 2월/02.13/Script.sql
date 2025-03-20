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

update tbl_todo set writer = 'user00' where tno > 0;
create table tbl_user (
 uid varchar(100) primary key,
 upw varchar(100) not null,
 uname varchar(100) not null,
 regDate timestamp default now(),
 modDate timestamp default now()
)
;
insert into tbl_user (uid, upw, uname) values ('user00','1111','USER00');

insert into tbl_user (uid, upw, uname) values ('user01','1111','USER01');

insert into tbl_user (uid, upw, uname) values ('user02','1111','USER02');

insert into tbl_user (uid, upw, uname) values ('user03','1111','USER03');

insert into tbl_user (uid, upw, uname) values ('user04','1111','USER04');

insert into tbl_user (uid, upw, uname) values ('user05','1111','USER05');

alter table tbl_todo
add constraint fk_user_todo foreign key (writer)
references tbl_user(uid)
;

select * from tbl_user;

