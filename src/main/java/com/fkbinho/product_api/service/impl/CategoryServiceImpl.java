package com.fkbinho.product_api.service.impl;

import com.fkbinho.product_api.controller.dto.CategoryDTO;
import com.fkbinho.product_api.domain.model.Category;
import com.fkbinho.product_api.domain.repository.CategoryRepository;
import com.fkbinho.product_api.service.CategoryService;
import com.fkbinho.product_api.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        var entity = new Category();
        convertToEntity(categoryDTO, entity);
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CategoryDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public CategoryDTO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category ID " + id + " not found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category ID " + id + " not found"));

        convertToEntity(dto, entity);
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void deleteById(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Category ID " + id + " not found");
        }
        try{
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Referential integrity failure. " +
                                                      "Category ID " + id + " has associated entities");
        }
    }

    private void convertToEntity(CategoryDTO categoryDTO, Category entity) {
        entity.setName(categoryDTO.getName());
    }
}
