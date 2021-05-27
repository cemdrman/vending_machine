package com.bilisimio.output;

import com.bilisimio.enums.PaymentType;

import lombok.Data;

@Data
public class InvoiceResponse {

	private String productName;
	private int count;
	private PaymentType paymentType;
	private Double remainder;

}
