  use testdb;
  drop table if exists user;
   create table user( 
   id int primary key,
   username varchar(20) not null,
   birthdate date
   );

   insert into user ( id, username, birthdate ) values ( 10, '홍길동', current_date() );
   insert into user ( id, username, birthdate ) values ( 20, '이순신', current_date() );
   insert into user ( id, username, birthdate ) values ( 30, '유관순', current_date() );
   commit;