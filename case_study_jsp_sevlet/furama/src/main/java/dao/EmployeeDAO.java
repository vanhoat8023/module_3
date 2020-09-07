package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    boolean save(Employee employee);

    Employee findById(int id);

    int update(Employee employee);
    void remove(int id);
    boolean validateId();
    int nextId();
}
