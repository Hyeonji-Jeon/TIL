package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Product;

public interface ChatRepository extends JpaRepository<Product, Long> {
	
}
