package dao.contract_dao;

import dao.DBConnection;
import model.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO{
    @Override
    public List<Contract> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        List<Contract> contracts = new ArrayList<>();
        if (connection!=null){
            try {
                statement = connection.prepareStatement("select * from contract");
                resultSet = statement.executeQuery();
                Contract contract=null;
                while (resultSet.next()){
                    contract = new Contract();
                    contract.setId(resultSet.getInt("contract_id"));
                    contract.setStartDate(resultSet.getString("contract_start_date"));
                    contract.setEndDate(resultSet.getString("contract_end_date"));
                    contract.setDeposit(resultSet.getString("contract_deposit"));
                    contract.setTotalMoney(resultSet.getString("contract_total_money"));
                    contracts.add(contract);
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
        return contracts;
    }

    @Override
    public void save(Contract contract) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into contract(contract_id,contract_start_date,contract_end_date,contract_deposit,contract_total_money) value (?,?,?,?,?) ");
                statement.setInt(1,contract.getId());
                statement.setString(2,contract.getStartDate());
                statement.setString(3,contract.getEndDate());
                statement.setString(4,contract.getDeposit());
                statement.setString(5,contract.getTotalMoney());
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
    public int update(Contract contract) {
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
