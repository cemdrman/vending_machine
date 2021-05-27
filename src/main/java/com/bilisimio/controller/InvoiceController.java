package com.bilisimio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bilisimio.input.InvoiceRequest;
import com.bilisimio.output.InvoiceResponse;
import com.bilisimio.output.ServiceResponse;
import com.bilisimio.service.InvoiceService;

@RestController(value = "/api/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<InvoiceResponse>> getAllPost(
			@RequestBody(required = true) InvoiceRequest invoiceRequest) {
		return invoiceService.payInvoice(invoiceRequest);
	}

}
