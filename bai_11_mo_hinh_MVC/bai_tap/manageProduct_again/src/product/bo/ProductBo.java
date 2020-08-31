package product.bo;

import product.model.Product;

import java.util.List;

public interface ProductBo {
    List<Product> findAll();
    boolean save(Product product);

    Product findById(int id);

    boolean validateId();
}
