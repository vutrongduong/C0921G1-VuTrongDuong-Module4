package vn.codegym.service.contract_detail.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.contract_detail.Contract;
import vn.codegym.repository.contract_detail.IContractRepository;
import vn.codegym.service.contract_detail.IContractService;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> findAll(String customerName, String serviceName, Pageable pageable) {
        return contractRepository.search(customerName, serviceName, pageable);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> findById(Long id) {
        return contractRepository.findById(id);
    }
}
