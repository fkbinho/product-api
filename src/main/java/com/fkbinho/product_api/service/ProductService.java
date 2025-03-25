package com.fkbinho.product_api.service;

import com.fkbinho.product_api.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    Optional<ProductDTO> findById(Long id);

    void deleteById(Long id);

    ProductDTO update(Long id, ProductDTO dto);
}
