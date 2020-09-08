package bo;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
    public void remove(int id) {
        employeeDAO.remove(id);
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
