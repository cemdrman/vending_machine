package com.bilisimio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bilisimio.output.ResponseBuilder;
import com.bilisimio.output.ServiceResponse;

@ControllerAdvice
public class VendingMachineExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ServiceResponse<Object> handleAllExceptions(Exception ex, WebRequest request) {
		return ResponseBuilder.failure(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VendingMachineException.class)
	public ServiceResponse<Object> handleBurrdaExceptions(Exception ex, WebRequest request) {
		return ResponseBuilder.failure(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
