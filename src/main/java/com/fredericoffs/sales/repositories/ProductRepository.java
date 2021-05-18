package com.fredericoffs.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fredericoffs.sales.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
