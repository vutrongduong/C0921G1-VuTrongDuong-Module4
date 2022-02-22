package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.employee.Division;
@Repository
public interface IDivisionRepository extends JpaRepository<Division,Long> {
}
