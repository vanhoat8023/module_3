package product.bo;

import product.dao.ProductDao;
import product.dao.ProductDaoImpl;
import product.model.Product;

import java.util.List;

public class ProductBoImpl implements ProductBo{
    ProductDao productDao = new ProductDaoImpl() {
    };

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findByName(String nameString) {
        return productDao.findByName(nameString);
    }

    @Override
    public void update(int id, Product product) {
        productDao.update(id,product);
    }


    @Override
    public void remove(int id) {
        productDao.remove(id);
    }

    @Override
    public int getNextId() {
        return productDao.getNextId();
    }
}
