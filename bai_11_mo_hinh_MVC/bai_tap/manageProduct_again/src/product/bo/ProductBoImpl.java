package product.bo;

import product.dao.ProductDao;
import product.dao.ProductDaoImpl;
import product.model.Product;

import java.util.List;

public class ProductBoImpl implements ProductBo{
    private ProductDao productDao = new ProductDaoImpl() {
    };
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public boolean save(Product product) {
        return  productDao.save(product);
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean validateId() {
        return false;
    }
}
