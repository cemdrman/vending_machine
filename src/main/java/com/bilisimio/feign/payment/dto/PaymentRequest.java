package com.bilisimio.feign.payment.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

	private String ccNo;
	private double price;
	private LocalDate date;
	private int cvc;
}
