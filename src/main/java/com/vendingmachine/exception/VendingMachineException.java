package com.vendingmachine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
public class VendingMachineException extends Exception {
	
	private String errorMessage;

}
