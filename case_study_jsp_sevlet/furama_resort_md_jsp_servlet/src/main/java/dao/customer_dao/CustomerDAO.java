package dao.customer_dao;

import model.Customer;
import model.Employee;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    int update(Customer customer);
    boolean remove(int id);
    boolean validateId();
    int nextId();
}
