CREATE TABLE tbl_student (

sid varchar(100) PRIMARY KEY,
sname varchar(100) not null,
major varchar(100) not null
    
)
;
insert into tbl_student (sid,sname,major) values ('20201231','전현지','전자통신공학과')
;
select * from tbl_student
;
UPDATE tbl_student SET major = '소프트웨어공학' WHERE sid = '20201231'
;
DELETE FROM tbl_student WHERE sid = '20201231'
;
CREATE TABLE tbl_board (
    bid INT AUTO_INCREMENT PRIMARY KEY,  -- 게시글 ID (자동 증가)
    title VARCHAR(255) NOT NULL,         -- 제목
    content TEXT NOT NULL,               -- 내용
    writer VARCHAR(100) NOT NULL,        -- 작성자
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP  -- 작성 시간
) 
;
insert into tbl_board (title,content,writer) values ('실습과제','데이터 조작 연습','전현지')
;
select * from tbl_board
;
update tbl_board set content = '수정된 내용' where title = '실습과제'
;
delete from tbl_board where writer = '전현지'
;
  


