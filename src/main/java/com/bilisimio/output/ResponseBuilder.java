package com.bilisimio.output;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

	private ResponseBuilder() {

	}

	public static <T> ResponseEntity<ServiceResponse<T>> success(T data, HttpStatus status) {
		ServiceResponseHeader header = new ServiceResponseHeader(status, null);
		ServiceResponse<T> response = new ServiceResponse<>(header, data);
		return new ResponseEntity<>(response, status);
	}

	public static <T> ResponseEntity<ServiceResponse<T>> failure(String errorMessage, HttpStatus status) {
		ServiceResponseHeader header = new ServiceResponseHeader(status, errorMessage);
		ServiceResponse<T> response = new ServiceResponse<>(header, null);
		return new ResponseEntity<>(response, status);
	}

}
