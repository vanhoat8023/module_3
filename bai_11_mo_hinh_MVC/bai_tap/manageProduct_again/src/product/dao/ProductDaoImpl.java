package product.dao;

import product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone", 100000));
        productList.add(new Product(2, "Galaxy", 200000));
        productList.add(new Product(3, "Xiaomi", 32000));
        productList.add(new Product(4, "Redmi", 400000));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
