package com.fkbinho.product_api.service;

import com.fkbinho.product_api.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void delete(Long id);

}
