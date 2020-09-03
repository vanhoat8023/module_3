package product.bo;

import product.dao.ProductDAO;
import product.dao.ProductDAOImpl;
import product.model.Product;

import java.util.List;

public class ProductBOImpl implements ProductBO {
    private ProductDAO productDAO=new ProductDAOImpl();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public int update(Product product) {
       return productDAO.update(product);
    }

    @Override
    public void remove(int id) {
        productDAO.remove(id);
    }

    @Override
    public boolean validateId() {
        return false;
    }

    @Override
    public int nextId() {
        return productDAO.nextId();
    }
}
