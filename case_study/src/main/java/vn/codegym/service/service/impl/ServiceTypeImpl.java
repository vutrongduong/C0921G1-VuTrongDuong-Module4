package vn.codegym.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.service.ServiceType;
import vn.codegym.repository.service.IServiceTypeRepository;
import vn.codegym.service.service.IServiceType;

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
