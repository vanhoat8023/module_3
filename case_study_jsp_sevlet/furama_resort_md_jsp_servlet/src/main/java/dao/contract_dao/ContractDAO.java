package dao.contract_dao;

import model.Contract;
import model.Service;

import java.util.List;

public interface ContractDAO {
    List<Contract> findAll();

    void save(Contract contract);

    int update(Contract contract);
    boolean remove(int id);
    boolean validateId();
    int nextId();
}
