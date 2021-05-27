package com.bilisimio.service;

import org.springframework.http.ResponseEntity;

import com.bilisimio.output.ProductResponse;
import com.bilisimio.output.ServiceResponse;

public interface ProductService {

	ResponseEntity<ServiceResponse<ProductResponse>> getAllProducts();

	ResponseEntity<ServiceResponse<ProductResponse>> getProduct(String productId);

}
