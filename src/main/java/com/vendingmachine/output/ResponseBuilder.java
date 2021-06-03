package com.vendingmachine.output;

import org.springframework.http.HttpStatus;

public class ResponseBuilder {

	private ResponseBuilder() {

	}

	public static <T> ServiceResponse<T> success(T data) {
		ServiceResponseHeader header = new ServiceResponseHeader(HttpStatus.OK, null);
		return new ServiceResponse<>(header, data);
	}
	
	public static <T> ServiceResponse<T> success(T data, HttpStatus status) {
		ServiceResponseHeader header = new ServiceResponseHeader(status, null);
		return new ServiceResponse<>(header, data);
	}
	
	public static <T> ServiceResponse<T> failure(String errorMessage) {
		ServiceResponseHeader header = new ServiceResponseHeader(HttpStatus.NOT_FOUND, errorMessage);
		return new ServiceResponse<>(header, null);
	}

	public static <T> ServiceResponse<T> failure(String errorMessage, HttpStatus status) {
		ServiceResponseHeader header = new ServiceResponseHeader(status, errorMessage);
		return new ServiceResponse<>(header, null);
	}

}
