package com.fredericoffs.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fredericoffs.order.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
