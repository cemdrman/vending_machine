package com.vendingmachine.feign.payment.dto;

import org.springframework.http.HttpStatus;

import com.vendingmachine.output.ServiceResponseHeader;

public class PaymentResponse extends ServiceResponseHeader {

	public PaymentResponse() {

	}
	
	public PaymentResponse(HttpStatus statusCode, String errorMessage) {
		super(statusCode, errorMessage);
		// TODO Auto-generated constructor stub
	}

}
