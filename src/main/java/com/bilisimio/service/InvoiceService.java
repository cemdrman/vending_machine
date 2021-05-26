package com.bilisimio.service;

import com.bilisimio.input.InvoiceRequest;
import com.bilisimio.output.InvoiceResponse;

public interface InvoiceService {

	InvoiceResponse payInvoice(InvoiceRequest invoiceRequest);

}
