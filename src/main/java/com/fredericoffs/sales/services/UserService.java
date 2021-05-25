package com.fredericoffs.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fredericoffs.sales.entities.User;
import com.fredericoffs.sales.repositories.UserRepository;
import com.fredericoffs.sales.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
