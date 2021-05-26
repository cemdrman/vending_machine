package com.bilisimio.output;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceResponseHeader {

	private HttpStatus statusCode;
	private String errorMessage;
}
