package vn.codegym.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.service.RentType;
import vn.codegym.repository.service.IRentTypeRepository;
import vn.codegym.service.service.IRentTypeService;

import java.util.List;
@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
