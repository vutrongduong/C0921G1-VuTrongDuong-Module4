package vn.codegym.service;

import vn.codegym.model.Contract;

import java.util.List;

public interface IContractService {
    void save(Contract contract);
    List<Contract> findAll();
}
