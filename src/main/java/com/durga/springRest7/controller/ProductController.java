package com.durga.springRest7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.durga.springRest7.dto.ProductDto;
import com.durga.springRest7.exception.ProductFoundException;
import com.durga.springRest7.exception.ProductNotFoundException;
import com.durga.springRest7.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	public ProductService service;
	@PostMapping("/products")
	public ResponseEntity<Object> add(@RequestBody ProductDto dto)throws ProductFoundException {
		
			ProductDto prod=service.add(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(prod);
		
	}
	@PutMapping("/products/{pid}")
	public ResponseEntity<Object> update(@PathVariable int pid,@RequestBody ProductDto dto)throws ProductNotFoundException {
		
			ProductDto prod=service.update(pid, dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(prod);
		
	}
	@GetMapping("/get/{pid}")
	public ResponseEntity<Object> get(@PathVariable int pid)throws ProductNotFoundException {
		
			ProductDto prod=service.get(pid);
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll()throws ProductNotFoundException {
		
			List<ProductDto> prod=service.getAll();
			return ResponseEntity.status(HttpStatus.OK).body(prod);
		
	}
	@DeleteMapping("/get/{pid}")
	public ResponseEntity<Object> delete(@PathVariable int pid)throws ProductNotFoundException {
		
			service.delete(pid);
			return ResponseEntity.status(HttpStatus.OK).body("Product Deleted successfully");
		
	}

}
