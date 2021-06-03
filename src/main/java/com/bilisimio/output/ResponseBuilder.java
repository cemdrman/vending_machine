package com.bilisimio.output;

import org.springframework.http.HttpStatus;

public class ResponseBuilder {

	private ResponseBuilder() {

	}

	public static <T> ServiceResponse<T> success(T data, HttpStatus status) {
		ServiceResponseHeader header = new ServiceResponseHeader(status, null);
		return new ServiceResponse<>(header, data);
	}

	public static <T> ServiceResponse<T> failure(String errorMessage, HttpStatus status) {
		ServiceResponseHeader header = new ServiceResponseHeader(status, errorMessage);
		return new ServiceResponse<>(header, null);
	}

}
