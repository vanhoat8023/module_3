package dao.contract_detail_dao;

import dao.DBConnection;
import model.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Contract_detail_DAOImpl implements Contract_detail_DAO{
    @Override
    public List<ContractDetail> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet= null;
        List<ContractDetail> contractDetails = new ArrayList<>();
        if (connection!=null){
            try {
                statement = connection.prepareStatement("select * from contract_detail");
                resultSet = statement.executeQuery();
                ContractDetail contractDetail=null;
                while (resultSet.next()){
                    contractDetail = new ContractDetail();
                    contractDetail.setId(resultSet.getInt("contract_detail_id"));
                    contractDetail.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
                    contractDetails.add(contractDetail);
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
        return contractDetails;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into contract_detail(contract_detail_id,quantity) value (?,?) ");
                statement.setInt(1,contractDetail.getId());
                statement.setInt(2,contractDetail.getQuantity());
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
}
