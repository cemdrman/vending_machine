package com.vendingmachine.service.impl;

import org.springframework.http.HttpStatus;

import com.vendingmachine.output.BasketResponse;
import com.vendingmachine.output.ResponseBuilder;
import com.vendingmachine.output.ServiceResponse;
import com.vendingmachine.service.BasketService;

public class BasketServiceImpl implements BasketService {

	@Override
	public ServiceResponse<BasketResponse> addProduct(String productId, String count) {
		return ResponseBuilder.success(new BasketResponse(), HttpStatus.OK);
	}

}
