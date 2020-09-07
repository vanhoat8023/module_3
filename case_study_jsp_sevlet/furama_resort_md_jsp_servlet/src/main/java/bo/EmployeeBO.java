package bo;

import model.Employee;

import java.util.List;

public interface EmployeeBO {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    int update(Employee employee);
    void remove(int id);
    boolean validateId();
    int nextId();
}
