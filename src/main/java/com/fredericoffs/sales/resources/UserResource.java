package com.fredericoffs.sales.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fredericoffs.sales.entities.User;
import com.fredericoffs.sales.services.UserService;

// recurso web implementado por um controlador REST
@RestController
// identifica o endereço 
@RequestMapping(value = "/users")
public class UserResource {

	// injecao de dependência do service, userResource depende o UserService
	@Autowired
	private UserService userService;

	// retornar resposta de requisição web
	// testar o recurso
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
