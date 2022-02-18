package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Employee;
import vn.codegym.repository.IEmployeeRepository;
import vn.codegym.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository repository;

    @Override
    public void add(Employee employee) {
        repository.save(employee);
    }
}
