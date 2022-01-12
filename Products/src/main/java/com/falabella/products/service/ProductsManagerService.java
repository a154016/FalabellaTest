package com.falabella.products.service;

import java.util.List;
import java.util.Optional;


import com.falabella.products.model.Product;

public interface ProductsManagerService {

	List<Product> getAllProducts();

	Optional<Product> getProductBySku(String sku);

	void updateProduct(String sku);

	void addProduct(Product product);

	void deleteProduct(Product product);
	
	

}