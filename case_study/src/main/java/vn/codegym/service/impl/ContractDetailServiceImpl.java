package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.IContractDetailRepository;
import vn.codegym.service.IContractDetailService;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository repository;

    @Override
    public void add(ContractDetail contractDetail) {
        repository.save(contractDetail);
    }
}
