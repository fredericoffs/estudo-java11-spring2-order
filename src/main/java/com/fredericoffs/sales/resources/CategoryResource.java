package com.fredericoffs.sales.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fredericoffs.sales.entities.Category;
import com.fredericoffs.sales.services.CategoryService;

// recurso web implementado por um controlador REST
@RestController
// identifica o endereço 
@RequestMapping(value = "/categories")
public class CategoryResource {

	// injecao de dependência do service, userResource depende o UserService
	@Autowired
	private CategoryService service;

	// retornar resposta de requisição web
	// testar o recurso
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
