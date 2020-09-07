drop database if exists product;
create database product;
use product;
create table product(
id int(3) not null primary key auto_increment,
`name` varchar(120) not null,
address varchar(120) not null
);
insert into product(id,`name`,address) value (1,'hoat','quang binh'),
(2,'tuan','quang binh');

select * from product;