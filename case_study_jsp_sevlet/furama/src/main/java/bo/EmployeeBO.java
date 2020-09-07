package main.java.bo;

import main.java.model.Employee;

import java.util.List;

public interface EmployeeBO {
    List<Employee> findAll();

    boolean save(Employee product);

    Employee findById(int id);

    int update(Employee employee);
    void remove(int id);
    boolean validateId();
    int nextId();
}
