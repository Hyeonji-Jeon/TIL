
insert into locker(locker_id,name)
values(40001,'E123456');
insert into locker(locker_id,name)
values(40002,'N123457');
insert into locker(locker_id,name)
values(40003,'L123890');
insert into locker(locker_id,name)
values(40004,'A123890');


insert into member(member_id,username, locker_id)
values(20001,'Ranga', 40001);
insert into member(member_id,username, locker_id)
values(20002,'Adam', 40002);
insert into member(member_id,username, locker_id)
values(20003,'Jane', 40003);

commit;