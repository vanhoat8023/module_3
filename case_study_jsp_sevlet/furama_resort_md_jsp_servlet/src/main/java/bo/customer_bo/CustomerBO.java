package bo.customer_bo;

import model.Customer;

import java.util.List;

public interface CustomerBO {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    int update(Customer customer);
    void remove(int id);
    boolean validateMKH(String string);
    boolean validateSDT(String string);
    int nextId();
}
