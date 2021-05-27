package com.bilisimio.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bilisimio.output.BasketResponse;
import com.bilisimio.output.ResponseBuilder;
import com.bilisimio.output.ServiceResponse;
import com.bilisimio.service.BasketService;

public class BasketServiceImpl implements BasketService {

	@Override
	public ResponseEntity<ServiceResponse<BasketResponse>> addProduct(String productId, String count) {
		return ResponseBuilder.success(new BasketResponse(), HttpStatus.OK);
	}

}
