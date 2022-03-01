package vn.codegym.dto;

import vn.codegym.model.Category;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


public class ProductDto {

    private Long id;
    @NotEmpty(message = "PLease input name")
    private String name;
    @NotNull(message = "PLease input name")
    @Positive
    private Long price;
    @NotEmpty(message = "Nhap quantity")
    private String quantity;
    @NotEmpty(message = "PLease input name")
    private String color;
    @NotNull(message = "Please select your gender")
    private Category category;

    public ProductDto() {
    }

    public ProductDto(Long id, @NotEmpty(message = "Nhap name") String name, @NotNull(message = "Nhap price") @Positive Long price, @NotEmpty(message = "Nhap quantity") String quantity, @NotEmpty(message = "Nhap color") String color, @NotNull(message = "Nhap category") Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
