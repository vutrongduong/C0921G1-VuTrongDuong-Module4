package vn.codegym.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.service.IServiceRepository;
import vn.codegym.service.contract_detail.IContractService;
import vn.codegym.service.service.IService;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements IService {
    @Autowired
    private IServiceRepository repository;

    @Override
    public void add(vn.codegym.model.service.Service service) {
        repository.save(service);
    }

    @Override
    public List<vn.codegym.model.service.Service> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<vn.codegym.model.service.Service> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(vn.codegym.model.service.Service service) {
        repository.delete(service);
    }
}
