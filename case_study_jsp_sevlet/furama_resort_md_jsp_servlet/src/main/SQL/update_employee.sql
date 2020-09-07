delimiter //
CREATE PROCEDURE `update_employee_by_id` (
	v_id int,
	v_name varchar(45),
	v_birthday date,
	v_id_card varchar(45),
	v_salary double,
	v_phone varchar(45),
	v_email varchar(45),
	v_address varchar(45)
)
BEGIN
update employee
set employee_name = v_name,
	employee_birthday=v_birthday,
    employee_id_card = v_id_card,
    employee_salary= v_salary,
    employee_phone= v_phone,
    employee_email= v_email,
    employee_address=v_address
where employee_id= v_id;
end //
delimiter ;
