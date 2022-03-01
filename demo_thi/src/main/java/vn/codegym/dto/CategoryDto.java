package vn.codegym.dto;

import vn.codegym.model.Product;

import java.util.List;

public class CategoryDto {
    private Long id;
    private String name;
    private List<Product> product;

    public CategoryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
