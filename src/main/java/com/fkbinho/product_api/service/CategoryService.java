package com.fkbinho.product_api.service;


import com.fkbinho.product_api.controller.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO save(CategoryDTO dto);

    List<CategoryDTO> findAll();

    CategoryDTO findById(Long id);

    CategoryDTO update(Long id, CategoryDTO dto);

    void deleteById(Long id);
}
