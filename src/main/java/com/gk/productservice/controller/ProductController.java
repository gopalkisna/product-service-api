package com.gk.productservice.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gk.productservice.model.Product;
import com.gk.productservice.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/category/{categoryId}/products")
	public Page<Product> getAllProducts(@PathVariable(value = "categoryId") String categoryId, Pageable pageable) {
		return productService.findByCategoryId(categoryId, pageable);
	}

	@PostMapping("/category/{categoryId}/products")
	public Product saveProducts(@PathVariable(value = "categoryId") String categoryId,
			@Valid @RequestBody Product product) {
		return productService.saveProduct(categoryId, product);
	}

	@PutMapping("/category/{categoryId}/product/{productId}")
	public Product updateProduct(@PathVariable(value = "categoryId") String categoryId,
			@PathVariable(value = "productId") String productId, @Valid @RequestBody Product requestProduct) {
		return productService.updateProduct(categoryId, productId, requestProduct);
	}

	@DeleteMapping("/category/{categoryId}/product/{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "categoryId") String categoryId,
			@PathVariable(value = "productId") String productId) {
		return productService.deleteProduct(categoryId, productId);
	}
}
