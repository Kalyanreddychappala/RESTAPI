package com.durga.springRest7.service;

import java.util.List;

import com.durga.springRest7.dto.ProductDto;
import com.durga.springRest7.exception.ProductFoundException;
import com.durga.springRest7.exception.ProductNotFoundException;

public interface ProductService {
	
	public ProductDto add(ProductDto dto)throws ProductFoundException;
	public ProductDto update(int pid,ProductDto dto)throws ProductNotFoundException;
	public ProductDto get(int pid)throws ProductNotFoundException;
	public List<ProductDto> getAll()throws ProductNotFoundException;
	public void delete(int pid)throws ProductNotFoundException;
}
