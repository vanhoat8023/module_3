package main.java.dao;

import main.java.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        List<Employee> employeesList = new ArrayList<>();
        if (connection!=null){
            try {
                statement = connection.prepareStatement("select*from employee");
                resultSet = statement.executeQuery();
                Employee employee;
                while (resultSet.next()){
                    employee = new Employee();
                    employee.setId(resultSet.getInt("employee_id"));
                    employee.setName(resultSet.getString("employee_name"));
                    employee.setId_card(resultSet.getString("employee_id_card"));
                    employee.setBirthday(resultSet.getString("employee_birthday"));
                    employee.setId_card(resultSet.getString("employee_id_card"));
                    employee.setSalary(resultSet.getInt("employee_salary"));
                    employee.setPhone(resultSet.getInt("employee_phone"));
                    employee.setEmail(resultSet.getString("employee_email"));
                    employee.setAddress(resultSet.getString("employee_address"));
                    employeesList.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return employeesList;
    }

    @Override
    public boolean save(Employee employee) {
        return false;
    }

    @Override
    public int nextId() {
        return 0;
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean validateId() {
        return false;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }
}
