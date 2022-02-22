package vn.codegym.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.employee.EducationDegree;
import vn.codegym.repository.employee.IEducationDegreeRepository;
import vn.codegym.service.employee.IEducationDegreeService;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository repository;

    @Override
    public List<EducationDegree> findAll() {
        return repository.findAll();
    }
}
