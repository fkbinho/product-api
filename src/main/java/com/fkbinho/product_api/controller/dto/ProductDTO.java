package com.fkbinho.product_api.controller.dto;

import com.fkbinho.product_api.domain.model.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private CategoryDTO category;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, CategoryDTO category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
        this.category = new CategoryDTO(entity.getCategory());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public CategoryDTO getCategory() {
        return category;
    }
}
