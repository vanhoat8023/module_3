package main.java.bo;

import main.java.model.Employee;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public boolean save(Employee product) {
        return false;
    }

    @Override
    public Employee findById(int id) {
        return null;
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
    public int nextId() {
        return 0;
    }
}
