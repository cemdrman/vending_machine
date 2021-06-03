package com.bilisimio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.exception.VendingMachineException;
import com.bilisimio.input.InvoiceRequest;
import com.bilisimio.output.InvoiceResponse;
import com.bilisimio.output.ServiceResponse;
import com.bilisimio.service.InvoiceService;

@RestController("/api/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResponse<InvoiceResponse> payInvoice(@RequestBody(required = true) InvoiceRequest invoiceRequest) throws VendingMachineException {
		return invoiceService.payInvoice(invoiceRequest);
	}

}
