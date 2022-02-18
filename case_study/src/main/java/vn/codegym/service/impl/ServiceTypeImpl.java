package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.ServiceType;
import vn.codegym.repository.IServiceTypeRepository;
import vn.codegym.service.IServiceType;

import java.util.List;
@Service
public class ServiceTypeImpl implements IServiceType {
    @Autowired
    private IServiceTypeRepository repository;

    @Override
    public List<ServiceType> findAll() {
        return repository.findAll();
    }
}
