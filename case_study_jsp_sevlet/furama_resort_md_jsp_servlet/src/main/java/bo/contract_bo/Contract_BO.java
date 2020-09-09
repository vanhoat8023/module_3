package bo.contract_bo;

import model.Contract;


import java.util.List;

public interface Contract_BO {
    List<Contract> findAll();

    List<Contract> findByName(String string);
    void save(Contract contract);

    Contract findById(int id);

    int update(Contract contract);
    void remove(int id);
    boolean validateMKH(String string);
    int nextId();
}
