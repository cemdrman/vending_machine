package com.bilisimio.service;

import com.bilisimio.output.ProductResponse;

public interface BasketService {

	ProductResponse addProduct(String productId, String count);

}
