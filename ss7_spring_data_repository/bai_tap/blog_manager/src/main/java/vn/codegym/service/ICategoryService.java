package vn.codegym.service;

import vn.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    void remove(Long id);
}
