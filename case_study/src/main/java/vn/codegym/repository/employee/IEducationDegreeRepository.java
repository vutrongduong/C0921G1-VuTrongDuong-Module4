package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.employee.EducationDegree;
@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Long> {
}
