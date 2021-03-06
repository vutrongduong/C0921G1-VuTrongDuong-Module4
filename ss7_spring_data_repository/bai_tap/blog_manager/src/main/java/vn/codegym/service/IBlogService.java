package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog customer);

    void remove(Long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByName(String name, Pageable pageable);

    Page<Blog> findByCategory(Long id, Pageable pageable);

    Page<Blog> findByNameAndCategory(String name, Long id, Pageable pageable);
}
