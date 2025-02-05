Web MVC 구조 - SSR

Controller (url처리) - Servlet

View - JSP (화면 출력)

Model- Service 등이 발생하는 데이터

Todo 를 위한 화면 구성 설계 

MariaDB

root 계정으로 하는 일 

- 신규 작업을 위한 데이터베이스 생성 
- 신규 사용자 구성 
- 사용자에게 권한을 부여 
- 백업/복구 


SQL 종류 - 오브젝트  - 데이터베이스, 사용자, 권한, 테이블, 레코드(엔티티), 인덱스.... 

DDL - 구조(객체)를 만들때  create, alter, drop, rename, truncate... 
- Data Definition Language 

CREATE DATABASE webdb;
CREATE USER 'webdbuser'@'localhost' IDENTIFIED BY 'webdbuser';
CREATE USER 'webdbuser'@'%' IDENTIFIED BY 'webdbuser';


DML - 데이터 조작 할 때  insert, update, delete...  (select) 
- Data Manipluration

DCL - 권한 조작  grant(권한 부여) , revoke(권한 제거) 
- Data Control 

GRANT ALL PRIVILEGES ON webdb.* TO 'webdbuser'@'localhost';

GRANT ALL PRIVILEGES ON webdb.* TO 'webdbuser'@'%';

TCL - 트랜잭션(commit, rollback, savepoint)


테이블 생성 연습

- tbl_student  

- sid varchar(100)  식별키 -- auto_increment가 아님 
- sname varchar(100) 학생이름 
- major varchar(100) 전공 

인터넷에 게시판 테이블들 SQL 수집  

데이터 조작 연습

(insert, select, update, delete) 


---------------------------------------

실습 내용 

DB설치 root계정 반드시 패스워드 기억 - 포트번호(3306)- 리스너 (서버소켓)

데이터베이스 생성 
CREATE DATABASE 본인의 DB이름;

계정 생성 - ip로 제한 
CREATE USER 계정명@'localhost' IDENTIFIED BY '패스워드';
CREATE USER 계정명@'%' IDENTIFIED BY '패스워드';

권한부여 

GRANT ALL PRIVILEGES ON 데이터베이스이름.* TO 계정;

GRANT ALL PRIVILEGES ON 데이터베이스이름.* TO 계정;

DBeaver 로 계정 접속 확인 

테이블 생성 연습

- tbl_student  

- sid varchar(100)  식별키 -- auto_increment가 아님 
- sname varchar(100) 학생이름 
- major varchar(100) 전공 

인터넷에 게시판 테이블들 SQL 수집  

데이터 조작 연습

(insert, select, update, delete) 
