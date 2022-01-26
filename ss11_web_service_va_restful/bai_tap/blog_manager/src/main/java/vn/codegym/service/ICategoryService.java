package vn.codegym.service;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
