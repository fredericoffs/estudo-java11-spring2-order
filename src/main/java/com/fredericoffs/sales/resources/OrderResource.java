package com.fredericoffs.sales.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fredericoffs.sales.entities.Order;
import com.fredericoffs.sales.services.OrderService;

// recurso web implementado por um controlador REST
@RestController
// identifica o endereço 
@RequestMapping(value = "/orders")
public class OrderResource {

	// injecao de dependência do service, userResource depende o OrderService
	@Autowired
	private OrderService service;

	// retornar resposta de requisição web
	// testar o recurso
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
