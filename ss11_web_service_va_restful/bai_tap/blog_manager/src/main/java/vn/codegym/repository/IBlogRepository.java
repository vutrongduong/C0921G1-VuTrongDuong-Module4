package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Blog;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    List<Blog> findBlogByCategoryName(String categoryName);
}
