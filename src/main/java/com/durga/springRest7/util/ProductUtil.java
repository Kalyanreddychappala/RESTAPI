package com.durga.springRest7.util;

import com.durga.springRest7.beans.Product;
import com.durga.springRest7.dto.ProductDto;

public class ProductUtil {
	
	public static ProductDto getProductDto(Product prod) {
		
		return new ProductDto();
	}
	public static Product getProduct(ProductDto dto) {
		return new Product();
	}

}
