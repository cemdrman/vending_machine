package com.bilisimio.service;

import com.bilisimio.exception.VendingMachineException;
import com.bilisimio.input.InvoiceRequest;
import com.bilisimio.output.InvoiceResponse;
import com.bilisimio.output.ServiceResponse;

public interface InvoiceService {

	ServiceResponse<InvoiceResponse> payInvoice(InvoiceRequest invoiceRequest) throws VendingMachineException;

}
