package com.bilisimio.service;

import org.springframework.http.ResponseEntity;

import com.bilisimio.input.InvoiceRequest;
import com.bilisimio.output.InvoiceResponse;
import com.bilisimio.output.ServiceResponse;

public interface InvoiceService {

	ResponseEntity<ServiceResponse<InvoiceResponse>> payInvoice(InvoiceRequest invoiceRequest);

}
