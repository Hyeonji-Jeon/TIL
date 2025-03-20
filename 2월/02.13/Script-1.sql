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

delete from tbl_user_cart where cino >0;



INSERT INTO tbl_user_cart (uid,pno,qty,regDate,modDate) VALUES
	 ('user01',3,3,'2025-02-12 15:36:12.000','2025-02-12 15:36:12.000'),
	 ('user02',3,1,'2025-02-12 16:15:57.000','2025-02-12 16:15:57.000'),
	 ('user03',5,2,'2025-02-12 16:57:30.000','2025-02-12 16:57:30.000'),
	 ('user03',4,1,'2025-02-12 16:57:53.000','2025-02-12 16:57:53.000'),
	 ('user01',4,1,'2025-02-12 17:00:46.000','2025-02-12 17:00:46.000');

select * from tbl_user_cart;

select
min(uid),
min(uname),
count(pno)
from
(
select
tu.uid, uname, pno
from
tbl_user tu
left outer join tbl_user_cart uc
on tu.uid = uc.uid
where tu.uid ='user01' and tu.upw = '1111'
) temp


select
min(uid), min(uname), count(pno), sum(amount)
from
(
select
tu.uid, tu.uname, tc.pno, tc.qty ,
IFNULL(tp.price,0) price ,
IFNULL( (tc.qty * tp.price),0) amount
from
tbl_user tu
left outer join tbl_user_cart tc on tu.uid = tc.uid
left outer join tbl_product tp on tc.pno = tp.pno
where
tu.uid ='user01' and tu.upw = '1111'
) a


select
pno, min(pname), min(price), sum(qty), (sum(qty) * min(a.price)) total
from
(
select
tp.pno, tp.pname ,tp.price, IFNULL(tuc.qty, 0) qty
from
tbl_product tp left outer join tbl_user_cart tuc on tp.pno = tuc.pno
) a
group by pno
order by total desc , pno asc








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








