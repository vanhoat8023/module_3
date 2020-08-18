drop database if exists library_manage;
create database library_manage;
use library_manage;

-- loại sách
create table category(
	id_category int primary key,
	name_category varchar(50)
);

-- học sinh
create table student(
	id_card int primary key,
	student_name varchar(50),
	student_birdthday date,
	address varchar(50),
	email varchar(50),
	phone varchar(10),
	image varchar(50),
    card_code int
);

-- sách
create table book( 
	book_id int primary key,
	book_name varchar(50) not null,
	publish varchar(50),
	author varchar (50),
	year_publish int,
	number_publish int,
	price double,
	image varchar(50),
    id_card int,
    id_category int,
    foreign key(book_id) references student(id_card),
    foreign key (id_category) references category(id_category)
);

-- thẻ mượn sách
create table brrow_order (
	book_id int,
    id_card int ,
	date_borrow date,
    date_return date,
    foreign key (book_id) references book(book_id),
    foreign key (id_card) references student(id_card)
);

