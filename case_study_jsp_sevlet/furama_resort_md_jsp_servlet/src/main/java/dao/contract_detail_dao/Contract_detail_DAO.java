package dao.contract_detail_dao;

import model.ContractDetail;

import java.util.List;

public interface Contract_detail_DAO {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
