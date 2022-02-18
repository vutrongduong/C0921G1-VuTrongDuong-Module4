package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Position;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Long> {
}
