package com.bilisimio.input;

import java.time.LocalDate;

import com.bilisimio.enums.PaymentType;

import lombok.Data;

@Data
public class InvoiceRequest {

	private String productId;
	private int count;
	private PaymentType type;
	private String ccNo;
	private LocalDate date;
	private int cvc;
	private int cash;

}
