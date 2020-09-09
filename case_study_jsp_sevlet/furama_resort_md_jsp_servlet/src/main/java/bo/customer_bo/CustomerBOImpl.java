package bo.customer_bo;

import dao.customer_dao.CustomerDAO;
import dao.customer_dao.CustomerDAOImpl;
import model.Customer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> findByName(String string) {
      return customerDAO.findByName(string);
    }

    @Override
    public int update(Customer customer) {
        return customerDAO.update(customer);
    }

    @Override
    public void remove(int id) {
        customerDAO.remove(id);
    }

    @Override
    public boolean validateMKH(String string) {
        String regexMKH = "[K][H][0-9]{4}";
        Pattern pattern = Pattern.compile(regexMKH);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()){
            return true;
        }else return false;
    }

    @Override
    public boolean validateSDT(String string) {
        String regexSDT = "[090|091|(+84)90|(+84)91][0-9]{4}";
        Pattern pattern = Pattern.compile(regexSDT);
        Matcher matcher = pattern.matcher(string);
        if (matcher.matches()){
            return true;
        }else return false;
    }

    ;


    @Override
    public int nextId() {
        return 0;
    }
}
