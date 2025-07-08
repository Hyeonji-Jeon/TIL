-- schema.sql

drop table if exists dept;

create table dept
( deptno int primary key,
  dname varchar(255) not null,
  loc varchar(255) not null
);
  