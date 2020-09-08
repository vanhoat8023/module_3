package dao.service_dao;

import dao.DBConnection;
import model.Customer;
import model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    @Override
    public List<Service> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        List<Service> serviceList = new ArrayList<>();
        if (connection!=null){
            try {
                statement = connection.prepareStatement("select * from service");
                resultSet = statement.executeQuery();
                Service service=null;
                while (resultSet.next()){
                    service = new Service();
                    service.setId(resultSet.getInt("service_id"));
                    service.setName(resultSet.getString("service_name"));
                    service.setArea(resultSet.getString("service_area"));
                    service.setCost(resultSet.getString("service_cost"));
                    service.setMaxPeople(resultSet.getString("service_max_people"));
                    service.setStandardRoom(resultSet.getString("standard_room"));
                    service.setDescriptionOtherConvenience(resultSet.getString("desciption_other_convenience"));
                    service.setPoolArea(resultSet.getString("pool_area"));
                    service.setNumberOfFloors(resultSet.getString("number_of_floors"));
                    serviceList.add(service);
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
        return serviceList;
    }

    @Override
    public void save(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into service(service_id,service_name,service_area,service_cost,service_max_people,standard_room,desciption_other_convenience,pool_area,number_of_floors) value (?,?,?,?,?,?,?,?,?) ");
                statement.setInt(1,service.getId());
                statement.setString(2,service.getName());
                statement.setString(3,service.getArea());
                statement.setInt(4,Integer.parseInt(service.getCost()));
                statement.setString(5,service.getMaxPeople());
                statement.setString(6,service.getStandardRoom());
                statement.setString(7,service.getDescriptionOtherConvenience());
                statement.setString(8,service.getPoolArea());
                statement.setString(9,service.getNumberOfFloors());
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
    public Service findById(int id) {
        return null;
    }

    @Override
    public int update(Service service) {
        return 0;
    }

    @Override
    public boolean remove(int id) {
        return false;
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
