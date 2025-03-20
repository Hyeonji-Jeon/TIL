create table tbl_product (
	    pno int primary key auto_increment,
	    pname varchar(200) not null,
	    price int not null,
	    img varchar(200) not null,
	    regdate timestamp default now(),
	    modDate timestamp default now()
	)
	;


	insert into tbl_product (pname, price, img) values ('P1', 3000, '1.jpg')
	;

	insert into tbl_product (pname, price, img) values ('P2', 4000, '2.jpg')
	;

	insert into tbl_product (pname, price, img) values ('P3', 5000, '3.jpg')
	;

	insert into tbl_product (pname, price, img) values ('P4', 6000, '4.jpg')
	;

	insert into tbl_product (pname, price, img) values ('P5', 7000, '5.jpg')
	;
	
	select * from tbl_product;
	
create table tbl_user_cart (
	cino int primary key auto_increment, 
	uid varchar(100) not null,
	pno int not null,
	qty int default 1,
	regDate timestamp default now(),
	modDate timestamp default now()
);

select
 count(*) 
from
 tbl_user_cart tuc  
where
 uid ='user01' 
and
 pno = 3
; 

update
 tbl_user_cart
set
 qty = qty+1
where 
 uid = 'user01'
and 
 pno = 3
;

insert into tbl_user_cart (uid, pno) values ('user01', 3)
;

select
 cino, uid, pno, tuc.qty  
from 
 tbl_user_cart tuc 
where 
 uid='user01'
;


alter table tbl_user_cart 
add constraint fk_user_cart foreign key (uid) 
references tbl_user(uid)
;

alter table tbl_user_cart 
add constraint fk_product_cart foreign key (pno) 
references tbl_product(pno)
;

create index idx_cart_user on tbl_user_cart (uid)
;








