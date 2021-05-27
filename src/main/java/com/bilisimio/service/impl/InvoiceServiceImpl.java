package com.bilisimio.service.impl;

import org.springframework.http.ResponseEntity;

import com.bilisimio.input.InvoiceRequest;
import com.bilisimio.output.InvoiceResponse;
import com.bilisimio.output.ServiceResponse;
import com.bilisimio.service.InvoiceService;

public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public ResponseEntity<ServiceResponse<InvoiceResponse>> payInvoice(InvoiceRequest invoiceRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
