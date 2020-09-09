package bo.contractDetail_bo;

import dao.contract_detail_dao.Contract_detail_DAO;
import dao.contract_detail_dao.Contract_detail_DAOImpl;
import model.ContractDetail;

import java.util.List;

public class Contract_detail_BOImpl implements Contract_detail_BO{
    Contract_detail_DAO contractDAO = new Contract_detail_DAOImpl();
    @Override
    public List<ContractDetail> findAll() {
        return contractDAO.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDAO.save(contractDetail);
    }
}
