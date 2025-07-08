
insert into Team(team_id,name)
values(90001,'E123456');
insert into Team(team_id,name)
values(90002,'N123457');
insert into Team(team_id,name)
values(90003,'L123890');

insert into member(member_id,username, team_id)
values(20001,'Ranga', 90001);
insert into member(member_id,username, team_id)
values(20002,'Adam', 90001);
insert into member(member_id,username, team_id)
values(20003,'Jane1', 90002);
insert into member(member_id,username, team_id)
values(20004,'Jane2', 90002);
insert into member(member_id,username, team_id)
values(20005,'Jane3', 90002);
insert into member(member_id,username, team_id)
values(20006,'John', 90003);

commit;