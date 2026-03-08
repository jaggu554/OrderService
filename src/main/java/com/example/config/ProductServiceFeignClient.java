package com.example.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.ProductDTO;

@FeignClient(name="product-service",url="http://localhost:8080")
public interface ProductServiceFeignClient {
	
	@GetMapping("/api/products/{id}")
	public ProductDTO getProductById(@PathVariable("id") Integer id);
}