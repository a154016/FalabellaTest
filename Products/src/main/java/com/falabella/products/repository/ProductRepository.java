package com.falabella.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.falabella.products.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	List<Product> findAll();

	void save(String sku);

	//boolean isPresent();
}
