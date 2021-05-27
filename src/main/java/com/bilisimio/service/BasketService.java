package com.bilisimio.service;

import org.springframework.http.ResponseEntity;

import com.bilisimio.output.BasketResponse;
import com.bilisimio.output.ServiceResponse;

public interface BasketService {

	ResponseEntity<ServiceResponse<BasketResponse>> addProduct(String productId, String count);

}
