package dao;

import model.Customer;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        List<Employee> employeeList = new ArrayList<>();
        if (connection!=null){
            try {
                statement = connection.prepareStatement("select * from employee");
                resultSet = statement.executeQuery();
                Employee employee=null;
                while (resultSet.next()){
                    employee = new Employee();
                    employee.setId(resultSet.getInt("employee_id"));
                    employee.setName(resultSet.getString("employee_name"));
                    employee.setId_card(resultSet.getString("employee_id_card"));
                    employee.setBirthday(resultSet.getString("employee_birthday"));
                    employee.setId_card(resultSet.getString("employee_id_card"));
                    employee.setSalary(resultSet.getString("employee_salary"));
                    employee.setPhone(resultSet.getString("employee_phone"));
                    employee.setEmail(resultSet.getString("employee_email"));
                    employee.setAddress(resultSet.getString("employee_address"));
                    employeeList.add(employee);
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
        return employeeList;
    }

    @Override
    public void save(Employee employee) {

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into employee(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address) value (?,?,?,?,?,?,?,?) ");
                statement.setInt(1,employee.getId());
                statement.setString(2,employee.getName());
                statement.setString(3,employee.getBirthday());
                statement.setString(4,employee.getId_card());
                statement.setString(5,employee.getSalary());
                statement.setString(6,employee.getPhone());
                statement.setString(7,employee.getEmail());
                statement.setString(8,employee.getAddress());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public int nextId() {
        return findAll().size()+1;
    }

    @Override
    public int update(Employee employee) {
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = null;
        int count = 0;
        if (connection!=null){
            try {
                callableStatement = connection.prepareCall("call update_employee_by_id(?,?,?,?,?,?,?,?)");
                callableStatement.setInt(1,employee.getId());
                callableStatement.setString(2,employee.getName());
                callableStatement.setString(3,employee.getBirthday());
                callableStatement.setString(4,employee.getId_card());
                callableStatement.setString(5, employee.getSalary());
                callableStatement.setString(6, employee.getPhone());
                callableStatement.setString(7,employee.getEmail());
                callableStatement.setString(8,employee.getAddress());
                count = callableStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return count;
    }

    @Override
    public boolean remove(int id) {
        boolean rowDelete=false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE employee_id = ?;");
                preparedStatement.setInt(1, id);
                rowDelete = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public boolean validateId() {
        return false;
    }

    @Override
    public Employee findById(int id) {
        return findAll().get(id-1);
    }

    @Override
    public List<Employee> findByName(String string) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> eList = new ArrayList<>();
        Employee el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("SELECT * FROM  employee WHERE `employee_name` like ?");
                statement.setString(1, "%" + string + "%");
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Employee();
                    el.setId(resultSet.getInt("employee_id"));
                    el.setName(resultSet.getString("employee_name"));
                    el.setBirthday(resultSet.getString("employee_birthday"));
                    el.setId_card(resultSet.getString("employee_id_card"));
                    el.setSalary(resultSet.getString("employee_salary"));
                    el.setPhone(resultSet.getString("employee_phone"));
                    el.setEmail(resultSet.getString("employee_email"));
                    el.setAddress(resultSet.getString("employee_address"));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return eList;
    }
}
