package br.com.fatecommerce.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecommerce.api.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByEanProduct(String eanProduct);

    List<Product> findBySkuProduct(String skuProduct);
    
    List<Product> findByNameProductIgnoreCaseContaining(String nameProduct);
}