package dao;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);
    List<Employee> findByName(String string);

    int update(Employee employee);
    boolean remove(int id);
    boolean validateId();
    int nextId();
}
