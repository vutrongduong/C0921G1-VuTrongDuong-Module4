package vn.codegym.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findByNameContaining(String name, Pageable pageable);

    List<Blog> findByNameContainingAndCategory_Id(String name, Long id, Pageable pageable);

    List<Blog> findByCategory_Id(Long id, Pageable pageable);

}
