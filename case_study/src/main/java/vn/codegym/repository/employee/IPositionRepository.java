package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.employee.Position;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Long> {
}
