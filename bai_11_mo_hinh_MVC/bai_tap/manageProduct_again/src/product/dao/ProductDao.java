package product.dao;

import product.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    List<Product> findByName(String nameString);

    void update(int id, Product element);

    void remove(int id);

    int getNextId();
}
