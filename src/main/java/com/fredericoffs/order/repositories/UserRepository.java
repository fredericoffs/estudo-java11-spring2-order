package com.fredericoffs.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericoffs.order.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
