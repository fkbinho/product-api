package com.fkbinho.product_api.service;

import com.fkbinho.product_api.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void deleteById(Long id);

    ProductDTO update(Long id, ProductDTO dto);
}
