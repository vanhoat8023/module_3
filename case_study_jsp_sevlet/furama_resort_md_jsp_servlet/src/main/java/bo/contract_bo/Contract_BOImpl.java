package bo.contract_bo;

import dao.contract_dao.ContractDAO;
import dao.contract_dao.ContractDAOImpl;
import model.Contract;

import java.util.List;

public class Contract_BOImpl implements Contract_BO{
    ContractDAO contractDAO = new ContractDAOImpl();
    @Override
    public List<Contract> findAll() {
        return contractDAO.findAll();
    }

    @Override
    public List<Contract> findByName(String string) {
        return null;
    }

    @Override
    public void save(Contract contract) {
        contractDAO.save(contract);
    }

    @Override
    public Contract findById(int id) {
        return null;
    }

    @Override
    public int update(Contract contract) {
        return 0;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public boolean validateMKH(String string) {
        return false;
    }

    @Override
    public int nextId() {
        return 0;
    }
}
