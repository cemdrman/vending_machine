package com.vendingmachine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.vendingmachine.enums.PaymentType;
import com.vendingmachine.exception.VendingMachineErrorCode;
import com.vendingmachine.exception.VendingMachineException;
import com.vendingmachine.feign.payment.PaymentClient;
import com.vendingmachine.feign.payment.dto.PaymentRequest;
import com.vendingmachine.feign.payment.dto.PaymentResponse;
import com.vendingmachine.input.InvoiceRequest;
import com.vendingmachine.output.InvoiceResponse;
import com.vendingmachine.output.ResponseBuilder;
import com.vendingmachine.output.ServiceResponse;
import com.vendingmachine.service.InvoiceService;
import com.vendingmachine.service.ProductService;

public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private PaymentClient paymentClient;

	@Autowired
	private ProductService productService;

	@Override
	public ServiceResponse<InvoiceResponse> payInvoice(InvoiceRequest invoiceRequest) throws VendingMachineException {

		PaymentResponse response = paymentClient.payInvoice(preparePaymentRequest(invoiceRequest));
		if (response.getStatusCode() != HttpStatus.OK) {
			throw new VendingMachineException(VendingMachineErrorCode.PAYMENT_UNSUCCESSFUL);
		}

		return prepareBill(invoiceRequest);
	}

	private ServiceResponse<InvoiceResponse> prepareBill(InvoiceRequest req) {
		InvoiceResponse invoiceResponse = new InvoiceResponse();
		invoiceResponse.setCount(req.getCount());
		invoiceResponse.setPaymentType(req.getType());
		invoiceResponse.setProductName(productService.getProductNameByName(req.getProductId()));
		if (invoiceResponse.getPaymentType() == PaymentType.CreditCard) {
			invoiceResponse.setRemainder(0d);
		} else {
			invoiceResponse.setRemainder(req.getCash() - calculatePrice(req.getProductId(), req.getCount()));
		}

		return ResponseBuilder.success(invoiceResponse);
	}

	private PaymentRequest preparePaymentRequest(InvoiceRequest request) {
		return new PaymentRequest(request.getCcNo(), calculatePrice(request.getProductId(), request.getCount()),
				request.getDate(), request.getCvc());
	}

	private double calculatePrice(String productId, int count) {
		return productService.getPriceById(productId) * count;
	}

}
