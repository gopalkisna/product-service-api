package com.gk.productservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.gk.productservice.exception.ResourceNotFoundException;
import com.gk.productservice.model.Category;
import com.gk.productservice.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public List<Category> saveCategories(List<Category> categories) {
		return categoryRepository.saveAll(categories);
	}

	public Category updateCategory(String categoryId, Category requestCategory) {
		return categoryRepository.findById(categoryId).map(category -> {
			category.setName(requestCategory.getName());
			category.setDescription(requestCategory.getDescription());

			return categoryRepository.save(category);
		}).orElseThrow(() -> new ResourceNotFoundException("CategoryId " + categoryId + " not found"));
	}

	public ResponseEntity<?> deleteCategory(String categoryId) {
		return categoryRepository.findById(categoryId).map(category -> {
			categoryRepository.delete(category);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("CategoryId " + categoryId + " not found"));
	}
}
