package product.dao;

import product.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from product");
                resultSet = statement.executeQuery();
                Product product = null;
                while (resultSet.next()) {
                    product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setAddress(resultSet.getString("address"));
                    productList.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        int count = 0;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into product(name, address) value (?,?);");
                statement.setString(1, product.getName());
                statement.setString(2, product.getAddress());
                count = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product findById(int id) {
        return null;
    }
}
