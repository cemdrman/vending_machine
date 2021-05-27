package com.bilisimio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.output.ProductResponse;
import com.bilisimio.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ProductResponse getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{productId}")
	public ProductResponse getProducts(@PathVariable String productId) {
		return productService.getProduct(productId);
	}

}
