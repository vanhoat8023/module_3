package product_management.dao;

import product_management.model.Product;

import java.util.*;

public class ProductDAOImplement implements ProductDAO {
    private static Map<Integer, Product> elements;

    static {
        elements = new HashMap<>();

        elements.put(1, new Product(1, "Iphone", "1000", "...", "1"));
        elements.put(2, new Product(2, "Galaxy", "2000", "...", "2"));
        elements.put(3, new Product(3, "Xiaomi", "3000", "...", "3"));
        elements.put(4, new Product(4, "Bphone", "4000", "...", "4"));
        elements.put(5, new Product(5, "Nokia", "5000", "...", "5"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(elements.values());
    }

    @Override
    public void save(Product element) {
        elements.put(element.getId(), element);
    }

    @Override
    public Product findById(int id) {
        return elements.get(id);
    }

    @Override
    public List<Product> findByName(String nameString) {
        List<Product> elementList = new ArrayList<>(elements.values());
        List<Product> elementFound = new ArrayList<>();
        for(Product element: elementList){
            if (element.getName().toLowerCase().contains(nameString.toLowerCase())) {
                elementFound.add(element);
            }
        }

        return elementFound;
    }

    @Override
    public void update(int id, Product element) {
        elements.put(id, element);
    }

    @Override
    public void remove(int id) {
        elements.remove(id);
    }

    @Override
    public int getNextId() {
        return elements.size() + 1;
    }
}
