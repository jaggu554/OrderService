package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.config.ProductServiceFeignClient;
import com.example.dto.ProductDTO;
import com.example.entity.Order;
import com.example.exception.OrderException;
import com.example.repository.OrderRepository;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ProductServiceFeignClient client;
	
	public ProductDTO createOrder(Order order) throws Exception {
		
		ProductDTO product=client.getProductById(order.getProductId());
		if(product==null) {
			throw new Exception("No Product Found  for :"+order.getProductId());
		}
		
		repo.save(order);
		return product;
	}
	
	public Order getOrderById(Integer id) {
		return repo.findById(id).orElseThrow(()-> new OrderException("Order not Found for id :"+id));
	}
	
	public List<Order> getAllOrders(){
		return repo.findAll();
	}
}
