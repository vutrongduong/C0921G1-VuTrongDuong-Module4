package vn.codegym.service.contract_detail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.contract_detail.Contract;

import java.util.Optional;


public interface IContractService {
    void save(Contract contract);

    Page<Contract> findAll(String customerName, String serviceName, Pageable pageable);

    Page<Contract> findAll(Pageable pageable);
    Optional<Contract> findById(Long id);
}
