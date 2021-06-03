package com.vendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.output.ProductResponse;
import com.vendingmachine.output.ServiceResponse;
import com.vendingmachine.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ServiceResponse<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{productId}")
	public ServiceResponse<ProductResponse> getProducts(@PathVariable String productId) {
		return productService.getProduct(productId);
	}

}
