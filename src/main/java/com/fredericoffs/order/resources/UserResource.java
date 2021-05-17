package com.fredericoffs.order.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fredericoffs.order.entities.User;

// recurso web implementado por um controlador REST
@RestController
// identifica o endereço 
@RequestMapping(value = "/users")
public class UserResource {

	// retornar resposta de requisição web
	// testar o recurso
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "123", "22222");
		return ResponseEntity.ok().body(u);
	}

}
