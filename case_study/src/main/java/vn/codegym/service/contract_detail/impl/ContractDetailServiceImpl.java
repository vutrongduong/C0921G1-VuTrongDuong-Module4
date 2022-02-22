package vn.codegym.service.contract_detail.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.contract_detail.ContractDetail;
import vn.codegym.repository.contract_detail.IContractDetailRepository;
import vn.codegym.service.contract_detail.IContractDetailService;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository repository;

    @Override
    public void add(ContractDetail contractDetail) {
        repository.save(contractDetail);
    }
}
