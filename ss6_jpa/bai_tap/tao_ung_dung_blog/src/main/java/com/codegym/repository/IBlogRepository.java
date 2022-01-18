package com.codegym.repository;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog customer);
    void remove(Long id);
}
