package com.vendingmachine.service;

import com.vendingmachine.output.BasketResponse;
import com.vendingmachine.output.ServiceResponse;

public interface BasketService {

	ServiceResponse<BasketResponse> addProduct(String productId, String count);

}
