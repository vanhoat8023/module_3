package product.dao;

import product.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    boolean save(Product product);
    Product findById(int id);
}
