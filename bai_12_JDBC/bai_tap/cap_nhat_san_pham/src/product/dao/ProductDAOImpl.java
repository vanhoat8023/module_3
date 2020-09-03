package product.dao;

import product.model.Product;

import java.sql.*;
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
        return findAll().get(id-1);
    }

    @Override
    public int nextId() {
        return findAll().size()+1;
    }

    @Override
    public int update(Product product) {
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = null;
        int count = 0;
        if (connection != null) {
            try {
                callableStatement = connection.prepareCall("call update_student_by_id(?,?,?);");
                callableStatement.setInt(1, product.getId());
                callableStatement.setString(2, product.getName());
                callableStatement.setString(3, product.getAddress());
                count = callableStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return count;
    }

    @Override
    public void remove(int id) {
        findAll().remove(id-1);
    }
}
