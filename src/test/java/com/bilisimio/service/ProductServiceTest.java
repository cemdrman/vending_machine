package com.bilisimio.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vendingmachine.output.ProductResponse;
import com.vendingmachine.output.ServiceResponse;
import com.vendingmachine.service.impl.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

	@InjectMocks
	private ProductServiceImpl productService;

	@Mock
	private ModelMapper modelMapper;

	@Test
	public void getAllProductsTest() {

		ServiceResponse<ProductResponse> products = productService.getAllProducts();

		assertEquals(HttpStatus.OK, products.getHeader().getStatusCode());

	}
}
