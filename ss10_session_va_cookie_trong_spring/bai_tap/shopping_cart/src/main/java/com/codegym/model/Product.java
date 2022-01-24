package com.codegym.model;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;
    private double priceOld;
    private double priceNow;
    private String description;

    public Product() {
    }

    public Product(String name, String img, double priceOld, double priceNow, String description) {
        this.name = name;
        this.img = img;
        this.priceOld = priceOld;
        this.priceNow = priceNow;
        this.description = description;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(double priceOld) {
        this.priceOld = priceOld;
    }

    public double getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(double priceNow) {
        this.priceNow = priceNow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}