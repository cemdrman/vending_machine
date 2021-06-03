package com.vendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.output.BasketResponse;
import com.vendingmachine.output.ServiceResponse;
import com.vendingmachine.service.BasketService;

@RestController("/api/baskets/")
public class BasketController {

	@Autowired
	private BasketService basketService;

	@PostMapping("{product_id}")
	public ServiceResponse<BasketResponse> getProducts(@PathVariable(value = "product_id") String productId,
			@RequestParam(name = "count") String count) {
		return basketService.addProduct(productId, count);
	}

}
