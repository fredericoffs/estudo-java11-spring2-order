package com.fredericoffs.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredericoffs.sales.entities.Order;
import com.fredericoffs.sales.repositories.OrderRepository;

// registrar a classe como um componente(service) do Spring
@Service
public class OrderService {

	// injeção de dependência
	@Autowired
	private OrderRepository repository;

	// Método para retornar todos os objetos do DB
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	// 
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
