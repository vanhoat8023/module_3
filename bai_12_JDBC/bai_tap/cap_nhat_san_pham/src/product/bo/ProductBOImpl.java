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
        return null;
    }

    @Override
    public boolean validateId() {
        return false;
    }
}
