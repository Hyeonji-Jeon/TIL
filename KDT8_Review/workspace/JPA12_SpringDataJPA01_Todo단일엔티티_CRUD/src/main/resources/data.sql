insert into todo(id, description, createdDate, lastUpdatedDate, done) 
values(10001,'JPA in 50 Steps', DATE_ADD(current_date(), INTERVAL -5 MONTH),  DATE_ADD(current_date(), INTERVAL -1 MONTH),false);
insert into  todo(id, description, createdDate, lastUpdatedDate,done) 
values(10002,'Spring in 50 Steps', DATE_ADD(current_date(), INTERVAL -2 MONTH),  DATE_ADD(current_date(), INTERVAL -15 DAY),false);
insert into  todo(id, description, createdDate, lastUpdatedDate,done) 
values(10003,'Spring Boot in 100 Steps', DATE_ADD(current_date(), INTERVAL -4 MONTH),  DATE_ADD(current_date(), INTERVAL -2 MONTH),false);
commit;