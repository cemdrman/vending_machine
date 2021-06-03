package com.bilisimio.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import com.bilisimio.model.Product;
import com.bilisimio.output.ProductResponse;
import com.bilisimio.output.ResponseBuilder;
import com.bilisimio.output.ServiceResponse;
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
	public ServiceResponse<ProductResponse> getAllProducts() {
		return ResponseBuilder.success(new ProductResponse(prepareProductList(productList)), HttpStatus.OK);
	}

	@Override
	public ServiceResponse<ProductResponse> getProduct(String productId) {
		List<Product> filteredList = productList.stream()
				.filter(product -> product.getId().equals(Integer.valueOf(productId))).collect(Collectors.toList());
		return ResponseBuilder.success(new ProductResponse(prepareProductList(filteredList)), HttpStatus.OK);
	}

	@Override
	public double getPriceById(String productId) {
		return productList.stream().filter(product -> product.getId().equals(Integer.valueOf(productId)))
				.collect(Collectors.toList()).get(0).getPrice();
	}

	@Override
	public String getProductNameByName(String productId) {
		return productList.stream().filter(product -> product.getId().equals(Integer.valueOf(productId)))
				.collect(Collectors.toList()).get(0).getName();
	}

}
