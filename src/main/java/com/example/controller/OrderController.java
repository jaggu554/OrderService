package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDTO;
import com.example.entity.Order;
import com.example.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/")
	public ProductDTO createOrder(@RequestBody Order order) throws Exception{
		
		return service.createOrder(order);
	}
	
	@GetMapping("/order")
	public Order getOrderById(@RequestParam("id")Integer id) {
		return service.getOrderById(id);
	}
	
	@GetMapping("/all")
	public List<Order> getAllOrders(){
		return service.getAllOrders();
	}
}
