package com.durga.springRest7.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.durga.springRest7.exception.ProductFoundException;
import com.durga.springRest7.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(exception={ProductFoundException.class,ProductNotFoundException.class})
	public ResponseEntity<Object> exceptionHandle(Exception e){
		Map<String,String> error=new HashMap<String,String>();
		error.put("message", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}

}
