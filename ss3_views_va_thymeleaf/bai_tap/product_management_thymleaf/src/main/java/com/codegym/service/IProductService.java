package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product customer);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);
    List<Product> search(String name);
}