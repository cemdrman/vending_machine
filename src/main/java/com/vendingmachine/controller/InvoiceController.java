package com.vendingmachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vendingmachine.exception.VendingMachineException;
import com.vendingmachine.input.InvoiceRequest;
import com.vendingmachine.output.InvoiceResponse;
import com.vendingmachine.output.ServiceResponse;
import com.vendingmachine.service.InvoiceService;

@RestController("/api/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResponse<InvoiceResponse> payInvoice(@RequestBody(required = true) InvoiceRequest invoiceRequest) throws VendingMachineException {
		return invoiceService.payInvoice(invoiceRequest);
	}

}
