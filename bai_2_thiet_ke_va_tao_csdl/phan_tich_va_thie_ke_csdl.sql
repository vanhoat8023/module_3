drop database if exists managa;
create database managa;
use managa;

create table office (
office_code varchar(10) not null unique primary key,
	city varchar(50) not null,
	phone varchar(50) not null,
	address_line1 varchar(50) not null,
	address_line2 varchar(50),
	state varchar(50),
	country varchar(50) not null,
	postal_code varchar(15) not null
);

create table employees (
	employee_number int primary key,
    last_name varchar(50) not null,
    first_name varchar(50) not null,
    email varchar(50) not null,
    job_title varchar(50) not null,
    report_to int(50), 
    office_code varchar(10), 
    foreign key (report_to) references employees(employee_number),
    foreign key(office_code) references office(office_code)
    );

create table customer (
		  customer_number int(10) primary key,
		  customer_name varchar(50) not null,
		  contact_last_name varchar(20) not null,
		  contact_first_name varchar(20) not null,
		  phone int(12) not null,
		  address_line varchar(50) not null,
		  city varchar(50) not null,
		  stase varchar(50) not null,
		  postal_code varchar(15) not null,
		  country varchar(50) not null,
		  credit_limit double,
		  sales_rep_employee_number int not null,
		  foreign key (sales_rep_employee_number) references employees(employee_number)
	);

create table orders (
	order_number int(50) primary key,
    order_date date not null,
    required_date date not null,
    shipped_date date,
    `status` varchar(15) not null,
    `comment` text,
    quantity_ordered int not null,
    price_each double not null,
    customer_number int(10),
    foreign key(customer_number) references customer(customer_number)
);


create table payment (
	customer_number int(10) not null,
    check_number varchar(50) not null,
    payment_day date not null,
    amount double not null,
    foreign key(customer_number) references customer(customer_number)
);

create table product_lines (
	product_lines varchar(50) primary key,
    text_ciption text,
    image varchar(50)
    );

create table product (
	product_code varchar(15) primary key,
    product_name varchar(70) not null,
    product_scale varchar(10) not null,
    product_vendor varchar(50) not null,
    product_description text not null,
    quantytiln_stock int not null,
    buy_price float not null,
    MSRP float not null,
    product_lines varchar(50),
    foreign key(product_lines) references product_lines(product_lines)
);

create table order_details (
	product_code varchar(15),
    order_number int not null,
    foreign key(product_code) references product(product_code),
    foreign key(order_number) references orders(order_number)
);





