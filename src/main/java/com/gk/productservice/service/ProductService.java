package com.gk.productservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gk.productservice.exception.ResourceNotFoundException;
import com.gk.productservice.model.Product;
import com.gk.productservice.repository.CategoryRepository;
import com.gk.productservice.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	public Page<Product> findByCategoryId(String categoryId, Pageable pageable) {
		return productRepository.findByCategoryId(categoryId, pageable);
	}

	public Product saveProduct(String categoryId, Product requestProduct) {
		return categoryRepository.findById(categoryId).map(category -> {
			requestProduct.setCategory(category);
			return productRepository.save(requestProduct);
		}).orElseThrow(() -> new ResourceNotFoundException("CategoryId " + categoryId + " not found"));
	}

	public Product updateProduct(String categoryId, String productId, Product requestProduct) {

		if (!categoryRepository.existsById(categoryId)) {
			throw new ResourceNotFoundException("CategoryId " + categoryId + " not found");
		}

		return productRepository.findById(productId).map(product -> {
			product.setName(requestProduct.getName());
			product.setDescription(requestProduct.getDescription());
			return productRepository.save(product);
		}).orElseThrow(() -> new ResourceNotFoundException("ProductId " + productId + "not found"));
	}

	public ResponseEntity<?> deleteProduct(String categoryId, String productId) {
		return productRepository.findByIdAndCategoryId(productId, categoryId).map(product -> {
			productRepository.delete(product);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Product not found with id " + productId + " and CategoryId " + categoryId));
	}
}
