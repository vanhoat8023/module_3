package bo;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public List<Employee> findByName(String string) {
        return employeeDAO.findByName(string);
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
    public boolean validateMKH(String string) {

        String regexMKH = "[D][V][0-9]{4}";
        Pattern pattern = Pattern.compile(regexMKH);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()){
            return true;
        }else return false;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
