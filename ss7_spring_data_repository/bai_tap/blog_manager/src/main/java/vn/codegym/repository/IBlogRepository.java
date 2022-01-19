package vn.codegym.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByName(String name, Pageable pageable);
    @Query(value="select * from blogs where blogs.category_id = :id", nativeQuery = true)
    List<Blog> findByCategoryId(@Param("id") Long id, Pageable pageable);
}
