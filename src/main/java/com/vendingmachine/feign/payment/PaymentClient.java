package com.vendingmachine.feign.payment;

import com.vendingmachine.feign.payment.dto.PaymentRequest;
import com.vendingmachine.feign.payment.dto.PaymentResponse;

public interface PaymentClient {
	
	PaymentResponse payInvoice(PaymentRequest request);

}
