package com.vendingmachine.feign.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vendingmachine.feign.payment.dto.PaymentRequest;
import com.vendingmachine.feign.payment.dto.PaymentResponse;

public class PaymentClientImpl implements PaymentClient {

	private static final String HX_CIRCUIT_NAME_PAYMENT = "ms-payment-service";

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PaymentFeign feign;

	@Override
	@HystrixCommand(commandKey = HX_CIRCUIT_NAME_PAYMENT, fallbackMethod = "defaultPayInvoice", threadPoolKey = HX_CIRCUIT_NAME_PAYMENT)
	public PaymentResponse payInvoice(PaymentRequest request) {
		return feign.payInvoice(request);
	}

	@FeignClient(url = "${feignClient.payment-service.url}", name = "${feignClient.payment-service.name}")
	public interface PaymentFeign {

		@PostMapping(value = "/payInvoice", produces = MediaType.APPLICATION_JSON_VALUE)
		PaymentResponse payInvoice(@RequestBody PaymentRequest request);

	}

	public PaymentResponse defaultPayInvoice(PaymentRequest request) {
		logger.warn("[defaultPayInvoice] {} is currently unreachable. Returning default payment response.",
				HX_CIRCUIT_NAME_PAYMENT);
		return new PaymentResponse();
	}

}
