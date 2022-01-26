package vn.codegym.service;

import vn.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    List<Blog> findByCategory(String category);
}
