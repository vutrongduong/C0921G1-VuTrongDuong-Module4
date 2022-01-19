package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
