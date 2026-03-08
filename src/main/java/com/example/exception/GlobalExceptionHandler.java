package com.example.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


	@ExceptionHandler(value=OrderException.class)
	public String handleOrderNotException(OrderException e) {
		return e.getMessage();
	}
}
