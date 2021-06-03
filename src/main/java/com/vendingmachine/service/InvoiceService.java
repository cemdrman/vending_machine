package com.vendingmachine.service;

import com.vendingmachine.exception.VendingMachineException;
import com.vendingmachine.input.InvoiceRequest;
import com.vendingmachine.output.InvoiceResponse;
import com.vendingmachine.output.ServiceResponse;

public interface InvoiceService {

	ServiceResponse<InvoiceResponse> payInvoice(InvoiceRequest invoiceRequest) throws VendingMachineException;

}
