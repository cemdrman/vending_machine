package com.vendingmachine.output;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiceResponse<T> {

	private ServiceResponseHeader header;
	private T data;

}
