package com.bilisimio.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.output.ProductResponse;
import com.bilisimio.service.ProductService;

@RestController(value = "api/products/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ProductResponse getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping(path = "{product_id}")
	public ProductResponse getProducts(@PathParam(value = "product_id") int productId) {
		return productService.getProduct(productId);
	}

}
