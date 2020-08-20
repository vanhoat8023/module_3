drop database if exists ham_thong_dung;
create database ham_thong_dung;
use ham_thong_dung;

create table text_ham (
	id int not null,
    `name` varchar(15) not null,
    age int not null,
    course varchar(15) not null,
    price long not null
);

-- them du lieu:
insert into text_ham value (1,"Hoang",21,"CNTT",400000);
insert into text_ham value (2,"Viet",18,"QTKS",450000);
insert into text_ham value (3,"Thai",19,"KHHT",350000);
insert into text_ham value (4,"Huong",20,"CK",500000);
insert into text_ham value (4,"Huong",20,"CK",450000);
select*from text_ham;

-- truy van du lieu

-- 1.Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
select *
from text_ham 
where `name`="Huong";

-- 2.Viết câu lệnh lấy ra tổng số tiền của Huong 
select sum(price) 
from text_ham 
where `name`="Huong";

-- 3.Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp
select distinct id,`name`,age,course
from text_ham;