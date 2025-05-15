package com.durga.springRest7.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durga.springRest7.beans.Product;
import com.durga.springRest7.dao.ProductDao;
import com.durga.springRest7.dto.ProductDto;
import com.durga.springRest7.exception.ProductFoundException;
import com.durga.springRest7.exception.ProductNotFoundException;
import com.durga.springRest7.util.ProductUtil;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao dao;

	@Override
	public ProductDto add(ProductDto dto) throws ProductFoundException {
		if(dao.findById(dto.getPid()).isPresent()) {
			throw new ProductFoundException("Product already existed: "+dto.getPid());
		}
		Product prod=ProductUtil.getProduct(dto);
		Product save=dao.save(prod);
		return ProductUtil.getProductDto(save);
	}

	@Override
	public ProductDto update(int pid, ProductDto dto) throws ProductNotFoundException {
		if(dao.findById(pid).isEmpty()) {
			throw new ProductNotFoundException("Product Not Existed: "+pid);
		}
		Product prod=ProductUtil.getProduct(dto);
		Product save=dao.save(prod);
		return ProductUtil.getProductDto(save);
	}

	@Override
	public ProductDto get(int pid) throws ProductNotFoundException {
		if(dao.findById(pid).isEmpty()) {
			throw new ProductNotFoundException("Product Not Existed: "+pid);
		}
		Product prod=dao.findById(pid).get();
		return ProductUtil.getProductDto(prod);
	}

	@Override
	public List<ProductDto> getAll() throws ProductNotFoundException {
		if(dao.findAll().isEmpty()) {
			throw new ProductNotFoundException("Products Not Existed: ");
		}
		List<Product> list=dao.findAll();
		return list.stream()
				.map(ProductUtil::getProductDto)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(int pid) throws ProductNotFoundException {
		if(dao.findById(pid).isEmpty()) {
			throw new ProductNotFoundException("Product Not Existed: "+pid);
		}
		dao.deleteById(pid);
		
	}

}
