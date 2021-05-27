package com.bilisimio.output;

import java.util.ArrayList;
import java.util.List;

import com.bilisimio.output.dto.ProductOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private List<ProductOutput> productList = new ArrayList<>();

}
