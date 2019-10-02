package com.gk.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.productservice.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

}
