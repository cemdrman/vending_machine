package com.bilisimio.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bilisimio.model.Product;
import com.bilisimio.output.ProductResponse;
import com.bilisimio.service.ProductService;

public class ProductServiceImpl extends ProductBaseService implements ProductService {

	private static List<Product> productList;

	static {
		productList = new ArrayList<>();
		productList.add(new Product(1, "Biskrem1", 1.5));
		productList.add(new Product(2, "Biskrem2", 2.5));
		productList.add(new Product(3, "Biskrem3", 1.5));
		productList.add(new Product(4, "Biskrem4", 1.5));
		productList.add(new Product(5, "Biskrem5", 1.5));
		productList.add(new Product(6, "Biskrem6", 1.5));
		productList.add(new Product(7, "Biskrem7", 1.5));
	}

	@Override
	public ProductResponse getAllProducts() {
		return convertToResponse(productList);
	}

	@Override
	public ProductResponse getProduct(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
