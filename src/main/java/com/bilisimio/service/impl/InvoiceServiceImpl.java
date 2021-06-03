package com.bilisimio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.bilisimio.enums.PaymentType;
import com.bilisimio.exception.VendingMachineErrorCode;
import com.bilisimio.exception.VendingMachineException;
import com.bilisimio.feign.payment.PaymentClient;
import com.bilisimio.feign.payment.dto.PaymentRequest;
import com.bilisimio.feign.payment.dto.PaymentResponse;
import com.bilisimio.input.InvoiceRequest;
import com.bilisimio.output.InvoiceResponse;
import com.bilisimio.output.ResponseBuilder;
import com.bilisimio.output.ServiceResponse;
import com.bilisimio.service.InvoiceService;
import com.bilisimio.service.ProductService;

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
