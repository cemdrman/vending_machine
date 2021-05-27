package com.bilisimio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.output.ProductResponse;
import com.bilisimio.service.BasketService;

@RestController("/api/basket")
public class BasketController {

	@Autowired
	private BasketService basketService;

	@PostMapping(path = "{product_id}")
	public ProductResponse getProducts(@PathVariable(value = "product_id") String productId,
			@RequestParam(name = "count") String count) {
		return basketService.addProduct(productId, count);
	}

}
