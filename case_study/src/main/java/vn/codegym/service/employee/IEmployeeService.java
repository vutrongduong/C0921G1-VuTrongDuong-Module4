package vn.codegym.service.employee;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import vn.codegym.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> search(String name, String positionId, String divisionId, String educationDegreeId, Pageable pageable);

    void edit(Employee employee);

    void delete(Employee employee);

    Optional<Employee> findById(Long id);

    void add(Employee employee);

    List<Employee> findAll();
}
