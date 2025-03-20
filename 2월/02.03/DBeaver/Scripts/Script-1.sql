select now();

# 2025-02-03 14:56:11.000

select * from todo t;


CREATE TABLE tbl_todo (

	tno INT AUTO_INCREMENT PRIMARY KEY ,
	title VARCHAR(100) NOT NULL,
	writer VARCHAR(50) NOT NULL

)
;

insert into tbl_todo (title,writer) values ('ddd','ffff')
;

select * from tbl_todo
;