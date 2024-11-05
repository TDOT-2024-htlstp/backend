package org.example.springbackend.services;

import org.example.springbackend.domain.Product;
import org.example.springbackend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record ProductService(ProductRepository productRepository) {

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductsForCategory(Long id) {
        return productRepository.getAllByCategoryIs(id);
    }

}
