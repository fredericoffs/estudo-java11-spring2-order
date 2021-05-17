package com.fredericoffs.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fredericoffs.sales.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
