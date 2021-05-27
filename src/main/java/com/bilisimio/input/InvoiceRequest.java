package com.bilisimio.input;

import com.bilisimio.enums.PaymentType;

import lombok.Data;

@Data
public class InvoiceRequest {

	private String productId;
	private String count;
	private PaymentType type;

}
