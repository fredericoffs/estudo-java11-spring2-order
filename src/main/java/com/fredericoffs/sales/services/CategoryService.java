package com.fredericoffs.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredericoffs.sales.entities.Category;
import com.fredericoffs.sales.repositories.CategoryRepository;

// registrar a classe como um componente(service) do Spring
@Service
public class CategoryService {

	// injeção de dependência
	@Autowired
	private CategoryRepository repository;

	// Método para retornar todos os objetos do DB
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	// 
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
