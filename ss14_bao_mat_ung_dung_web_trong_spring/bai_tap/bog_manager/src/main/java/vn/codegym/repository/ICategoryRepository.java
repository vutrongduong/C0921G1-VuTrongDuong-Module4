package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
