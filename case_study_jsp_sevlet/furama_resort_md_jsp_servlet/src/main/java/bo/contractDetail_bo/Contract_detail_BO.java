package bo.contractDetail_bo;

import model.Contract;
import model.ContractDetail;

import java.util.List;

public interface Contract_detail_BO {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
