package com.fkbinho.product_api.domain.repository;

import com.fkbinho.product_api.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repositório responsável por operações com a entidade Produto.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
