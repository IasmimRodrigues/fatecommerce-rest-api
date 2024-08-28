package br.com.fatecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecommerce.api.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
