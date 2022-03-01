package vn.codegym.service;

import vn.codegym.model.Category;

import java.util.List;

public interface ICategoryService extends IGeneral<Category> {
    List<Category> findAllCategory();
}
