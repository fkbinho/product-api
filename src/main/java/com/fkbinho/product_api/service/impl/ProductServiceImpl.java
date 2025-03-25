package com.fkbinho.product_api.service.impl;

import com.fkbinho.product_api.domain.model.Product;
import com.fkbinho.product_api.domain.repository.ProductRepository;
import com.fkbinho.product_api.dto.ProductDTO;
import com.fkbinho.product_api.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável pela lógica de negócios relacionada aos produtos.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public ProductDTO save(ProductDTO productDTO) {
        var entity = new Product();
        convertToEntity(productDTO, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ProductDTO::new)
                .toList();
    }


    @Override
    public Optional<ProductDTO> findById(Long id) {
        return repository.findById(id)
                .map(ProductDTO::new);
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado para exclusão");
        }
        repository.deleteById(id);
    }

    private void convertToEntity(ProductDTO productDTO, Product entity) {
        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setPrice(productDTO.getPrice());
    }
}
