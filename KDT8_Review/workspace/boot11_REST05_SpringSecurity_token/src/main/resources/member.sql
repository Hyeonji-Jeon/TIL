use testdb;

drop table if exists member;

 create table member (
   
   userid varchar(255) primary key,
   passwd varchar(255) not null,
   username varchar(255) not null 
 );