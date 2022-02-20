package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Employee;
import vn.codegym.repository.IEmployeeRepository;
import vn.codegym.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository repository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Employee> search(String name, String positionId, String divisionId, String educationDegreeId, Pageable pageable) {
        return repository.search(name, positionId, divisionId, educationDegreeId, pageable);
    }

    @Override
    public void edit(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        repository.delete(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(Employee employee) {
        repository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
