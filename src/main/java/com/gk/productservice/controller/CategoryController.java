package com.gk.productservice.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gk.productservice.model.Category;
import com.gk.productservice.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/all")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@PostMapping("/save")
	public List<Category> saveCategories(@RequestBody List<Category> categories) {
		return categoryService.saveCategories(categories);
	}

	@PutMapping("/{categoryId}")
	public Category updateCategory(@PathVariable String categoryId, @Valid @RequestBody Category requestCategory) {
		return categoryService.updateCategory(categoryId, requestCategory);

	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<?> deleteCategory(@PathVariable String categoryId) {
		return categoryService.deleteCategory(categoryId);
	}

}
