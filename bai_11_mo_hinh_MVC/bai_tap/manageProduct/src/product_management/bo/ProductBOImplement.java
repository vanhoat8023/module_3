package product_management.bo;

import product_management.dao.ProductDAO;
import product_management.dao.ProductDAOImplement;
import product_management.model.Product;

import java.util.List;

public class ProductBOImplement implements ProductBO {
    ProductDAO elementDAO = new ProductDAOImplement();
    @Override
    public List<Product> findAll() {
        return elementDAO.findAll();
    }

    @Override
    public void save(Product element) {
        elementDAO.save(element);

    }

    @Override
    public Product findById(int id) {
        return elementDAO.findById(id);
    }

    @Override
    public List<Product> findByName(String nameString) {
        return elementDAO.findByName(nameString);
    }

    @Override
    public void update(int id, Product element) {
        elementDAO.update(id, element);
    }

    @Override
    public void remove(int id) {
        elementDAO.remove(id);
    }

    @Override
    public int getNextId() {
        return elementDAO.getNextId();
    }
}
