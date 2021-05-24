package com.fredericoffs.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredericoffs.sales.entities.User;
import com.fredericoffs.sales.repositories.UserRepository;

// registrar a classe como um componente(service) do Spring
@Service
public class UserService {

	// injeção de dependência
	@Autowired
	private UserRepository repository;

	// Método para retornar todos os objetos do DB
	public List<User> findAll() {
		return repository.findAll();
	}

	//
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

}
