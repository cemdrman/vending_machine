package com.vendingmachine;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vendingmachine.service.BasketService;
import com.vendingmachine.service.InvoiceService;
import com.vendingmachine.service.ProductService;
import com.vendingmachine.service.impl.BasketServiceImpl;
import com.vendingmachine.service.impl.InvoiceServiceImpl;
import com.vendingmachine.service.impl.ProductServiceImpl;

@SpringBootApplication
public class VendingMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendingMachineApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public BasketService basketService() {
		return new BasketServiceImpl();
	}

	@Bean
	public InvoiceService invoiceService() {
		return new InvoiceServiceImpl();
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}

}
