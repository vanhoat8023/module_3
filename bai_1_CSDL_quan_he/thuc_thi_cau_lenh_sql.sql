-- Tạo bảng mới
create database session2;
use session2;
CREATE TABLE contacts (
    contact_id INT(11) AUTO_INCREMENT ,
    last_name VARCHAR(30) NOT NULL,
    first_name VARCHAR(25),
    birthday DATE,
    PRIMARY KEY (contact_id)
);
SELECT *FROM contacts;

-- xóa bảng
drop table contacts;

-- chỉnh sửa bảng đã có
alter table contacts add phone 
   varchar(15) not null after last_name;
ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
  
  -- xóa một cột trong bảng
  ALTER TABLE table_name
  DROP COLUMN column_name;
