package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.IServiceRepository;
import vn.codegym.service.IService;

import java.util.List;

@Service
public class ServiceImpl implements IService {
    @Autowired
    private IServiceRepository repository;

    @Override
    public void add(vn.codegym.model.Service service) {
        repository.save(service);
    }

    @Override
    public List<vn.codegym.model.Service> findAll() {
        return repository.findAll();
    }
}
