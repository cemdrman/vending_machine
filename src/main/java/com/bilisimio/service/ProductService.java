package com.bilisimio.service;

import com.bilisimio.output.ProductResponse;

public interface ProductService {

	ProductResponse getAllProducts();

	ProductResponse getProduct(int productId);

}
