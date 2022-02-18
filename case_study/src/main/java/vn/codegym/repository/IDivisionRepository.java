package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Division;
@Repository
public interface IDivisionRepository extends JpaRepository<Division,Long> {
}
