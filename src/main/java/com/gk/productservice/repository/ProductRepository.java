package com.gk.productservice.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gk.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
	Page<Product> findByCategoryId(String categoryId, Pageable pageable);
    Optional<Product> findByIdAndCategoryId(String id, String categoryId);

}
