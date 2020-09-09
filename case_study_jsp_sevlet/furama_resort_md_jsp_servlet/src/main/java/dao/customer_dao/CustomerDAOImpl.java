package dao.customer_dao;

import dao.DBConnection;
import model.Customer;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        List<Customer> customerList = new ArrayList<>();
        if (connection!=null){
            try {
                statement = connection.prepareStatement("select * from customer");
                resultSet = statement.executeQuery();
                Customer customer=null;
                while (resultSet.next()){
                    customer = new Customer();
                    customer.setId(resultSet.getInt("customer_id"));
                    customer.setCustomer_name(resultSet.getString("customer_name"));
                    customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                    customer.setCustomer_gender(resultSet.getString("customer_gender"));
                    customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                    customer.setCustomer_phone(resultSet.getString("customer_phone"));
                    customer.setCustomer_email(resultSet.getString("customer_email"));
                    customer.setCustomer_address(resultSet.getString("customer_address"));
                    customerList.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into customer(customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) value (?,?,?,?,?,?,?,?) ");
                statement.setInt(1,customer.getId());
                statement.setString(2,customer.getCustomer_name());
                statement.setString(3,customer.getCustomer_birthday());
                statement.setInt(4,Integer.parseInt(customer.getCustomer_gender()));
                statement.setString(5,customer.getCustomer_id_card());
                statement.setString(6,customer.getCustomer_phone());
                statement.setString(7,customer.getCustomer_email());
                statement.setString(8,customer.getCustomer_address());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Customer findById(int id) {
        return findAll().get(id-1);
    }

    @Override
    public List<Customer> findByName(String string) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> eList = new ArrayList<>();
        Customer el = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("SELECT * FROM  customer WHERE `customer_name` like ?");
                statement.setString(1, "%" + string + "%");
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    el = new Customer();
                    el.setId(resultSet.getInt("customer_id"));
                    el.setCustomer_name(resultSet.getString("customer_name"));
                    el.setCustomer_birthday(resultSet.getString("customer_birthday"));
                    el.setCustomer_gender(resultSet.getString("customer_gender"));
                    el.setCustomer_id_card(resultSet.getString("customer_id_card"));
                    el.setCustomer_phone(resultSet.getString("customer_phone"));
                    el.setCustomer_email(resultSet.getString("customer_email"));
                    el.setCustomer_address(resultSet.getString("customer_address"));

                    eList.add(el);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return eList;
    }

    @Override
    public int update(Customer customer) {
        Connection connection = DBConnection.getConnection();
        CallableStatement callableStatement = null;
        int count = 0;
        if (connection!=null){
            try {
                callableStatement = connection.prepareCall("call update_customer_by_id(?,?,?,?,?,?,?,?)");
                callableStatement.setInt(1,customer.getId());
                callableStatement.setString(2,customer.getCustomer_name());
                callableStatement.setString(3,customer.getCustomer_birthday());
                callableStatement.setInt(4,Integer.parseInt(customer.getCustomer_gender()));
                callableStatement.setString(5, customer.getCustomer_id_card());
                callableStatement.setString(6, customer.getCustomer_phone());
                callableStatement.setString(7,customer.getCustomer_email());
                callableStatement.setString(8,customer.getCustomer_address());
                count = callableStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
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
    public boolean remove(int id) {

        boolean rowDelete=false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE customer_id = ?;");
                preparedStatement.setInt(1, id);
                rowDelete = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public boolean validateId() {
        return false;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
