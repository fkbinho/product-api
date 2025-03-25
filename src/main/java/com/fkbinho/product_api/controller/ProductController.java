package com.fkbinho.product_api.controller;

import com.fkbinho.product_api.domain.model.Product;
import com.fkbinho.product_api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por expor endpoints REST para manipulação de produtos.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        var productSaved = service.save(product);
        return ResponseEntity.ok(productSaved);
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        var products = service.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        var product = service.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
