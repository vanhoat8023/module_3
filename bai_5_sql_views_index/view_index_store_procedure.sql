drop database if exists demo;
create database demo;
use demo;

create table products (
	id_product int primary key,
    product_code int not null,
    product_name varchar(50) default "hoat",
    product_price float default "0",
    product_amount float,
    product_desciption varchar(50),
    product_status varchar(50)
    );

 -- 1.1 Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục): 
 
create unique index index_products on products(product_code);

explain select product_code
from products;

-- 1.2 Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice):

create index index_composite on products(product_name,product_price);

-- 2.1 Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products:

create view product_view as 
select product_code, product_name, product_price, product_status
from products;

select *
from product_view;

-- 2.2 sửa đổi view:

create or replace view product_view as
select product_code, product_name, product_price
from products;

-- 2.3 xóa view:

drop view product_view;

-- 3.1 Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product:

create procedure store_procedure as
select *
from products;
