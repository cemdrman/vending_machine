package com.vendingmachine.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.vendingmachine.model.Product;
import com.vendingmachine.output.dto.ProductOutput;

public class ProductBaseService {

	@Autowired
	private ModelMapper modelMapper;

	protected List<ProductOutput> prepareProductList(List<Product> productList) {
		List<ProductOutput> outputs = new ArrayList<>();
		for (Product product : productList) {
			outputs.add(prepareProduct(product));
		}
		return outputs;
	}

	protected ProductOutput prepareProduct(Product product) {
		return modelMapper.map(product, ProductOutput.class);
	}

}
