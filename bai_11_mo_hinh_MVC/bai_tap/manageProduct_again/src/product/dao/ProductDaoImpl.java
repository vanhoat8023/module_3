package product.dao;

import product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone", "100000"));
        productList.add(new Product(2, "Galaxy", "200000"));
        productList.add(new Product(3, "Xiaomi", "32000"));
        productList.add(new Product(4, "Redmi", "400000"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    @Override
    public void save(Product product) {
        productList.add(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id-1);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productsList=new ArrayList<>(productList);
        List<Product> productsFound=new ArrayList<>();
        for (Product e:productsList){
            if (e.getName().toLowerCase().contains(name.toLowerCase())){
                productsFound.add(e);
            }
        }
        return productsFound;
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id-1,product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id-1);
    }

    @Override
    public int getNextId() {
        return productList.size()+1;
    }
}
