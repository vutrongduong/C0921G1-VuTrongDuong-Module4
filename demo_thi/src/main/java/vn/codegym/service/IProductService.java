package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Product;

public interface IProductService extends IGeneral<Product> {
    Page<Product> search(String name, String price, String category_id, String color, Pageable pageable);
}
