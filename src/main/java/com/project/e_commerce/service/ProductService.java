package com.project.e_commerce.service;

import com.project.e_commerce.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
       Product create(Product product);
       Product update(Product product);
       Optional<Product> getById(Long id);
       List<Product> searchByName(String keyword);
       void delete(Long id);
       List<Product> getAllProducts();
}
