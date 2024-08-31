package br.com.fatecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecommerce.api.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
    
}