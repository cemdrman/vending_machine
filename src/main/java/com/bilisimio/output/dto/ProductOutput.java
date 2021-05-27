package com.bilisimio.output.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOutput {

	private Integer id;
	private String name;
	private Double price;

}
