package com.vendingmachine.service;

import com.vendingmachine.output.ProductResponse;
import com.vendingmachine.output.ServiceResponse;

public interface ProductService {

	ServiceResponse<ProductResponse> getAllProducts();

	ServiceResponse<ProductResponse> getProduct(String productId);

	double getPriceById(String productId);

	String getProductNameByName(String productId);

}
