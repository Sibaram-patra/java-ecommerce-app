package com.project.e_commerce.service.impl;

import java.util.List;
import java.util.Optional;

import com.project.e_commerce.model.Product;
import com.project.e_commerce.repository.ProductRepository;
import com.project.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> searchByName(String keyword) {
		return productRepository.findByNameContainingIgnoreCase(keyword);
	}

	@Override
	public void delete(Long id) {
		 productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();	}

}
