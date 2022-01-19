package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByNameContaining(String name, Pageable pageable);

    Page<Blog> findByNameContainingAndCategory_Id(String name, Long id, Pageable pageable);

    Page<Blog> findByCategory_Id(Long id, Pageable pageable);

}
