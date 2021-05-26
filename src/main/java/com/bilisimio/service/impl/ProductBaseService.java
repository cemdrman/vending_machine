package com.bilisimio.service.impl;

import java.util.List;

import com.bilisimio.model.Product;
import com.bilisimio.output.ProductResponse;

public class ProductBaseService {

	protected ProductResponse convertToResponse(List<Product> productList) {
		ProductResponse response = new ProductResponse();
		return null;
	}

}
