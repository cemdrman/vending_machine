package com.bilisimio.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.output.ProductResponse;
import com.bilisimio.service.BasketService;

@RestController
public class BasketController {

	@Autowired
	private BasketService basketService;

	@PostMapping(path = "api/basket/{product_id}")
	public ProductResponse getProducts(@PathParam(value = "product_id") String productId,
			@RequestParam(name = "count") int count) {
		return basketService.addProduct(productId, count);
	}

}
