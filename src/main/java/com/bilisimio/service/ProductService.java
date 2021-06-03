package com.bilisimio.service;

import com.bilisimio.output.ProductResponse;
import com.bilisimio.output.ServiceResponse;

public interface ProductService {

	ServiceResponse<ProductResponse> getAllProducts();

	ServiceResponse<ProductResponse> getProduct(String productId);

}
