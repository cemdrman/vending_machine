package com.bilisimio.output;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponseHeader {

	private HttpStatus statusCode;
	private String errorMessage;
}
