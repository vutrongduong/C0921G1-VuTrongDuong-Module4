package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
