package product.bo;

import product.model.Product;

import java.util.List;

public interface ProductBO {
        List<Product> findAll();

        boolean save(Product product);

        Product findById(int id);

        int update(Product product);
        void remove(int id);
        boolean validateId();
        int nextId();
}
