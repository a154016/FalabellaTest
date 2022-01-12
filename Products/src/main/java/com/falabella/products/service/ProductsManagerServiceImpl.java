package com.falabella.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.falabella.products.model.Product;
import com.falabella.products.repository.ProductRepository;

@Service
public class ProductsManagerServiceImpl implements ProductsManagerService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductBySku(String id) {
		return productRepository.findById(id);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		Optional<Product> stock = productRepository.findById(product.getSku());

		productRepository.deleteById(product.getSku());

	}

	@Override
	public void updateProduct(String sku) {
		productRepository.save(sku);

	}

}