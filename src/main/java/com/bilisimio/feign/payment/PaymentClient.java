package com.bilisimio.feign.payment;

import com.bilisimio.feign.payment.dto.PaymentRequest;
import com.bilisimio.feign.payment.dto.PaymentResponse;

public interface PaymentClient {
	
	PaymentResponse payInvoice(PaymentRequest request);

}
