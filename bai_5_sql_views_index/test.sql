drop database if exists test;
create database test;
use test;

create table customer (
	id_customer int auto_increment,
    `name` varchar(20),
    age int,
    primary key(id_customer, `name`)
);

create table staff (
	id_staff int auto_increment primary key,
    id_customer int,
    `name` varchar(50),
    foreign key(id_customer) references customer(id_customer)
);

insert into customer value (1,"hoat",23);
drop table customer;
-- hien thi bang
select *
from customer;