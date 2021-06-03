package com.bilisimio.service;

import com.bilisimio.output.BasketResponse;
import com.bilisimio.output.ServiceResponse;

public interface BasketService {

	ServiceResponse<BasketResponse> addProduct(String productId, String count);

}
