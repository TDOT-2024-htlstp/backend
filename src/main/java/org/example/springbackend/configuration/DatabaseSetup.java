package org.example.springbackend.configuration;

import org.example.springbackend.domain.Category;
import org.example.springbackend.domain.Product;
import org.example.springbackend.repositories.CategoryRepository;
import org.example.springbackend.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseSetup {

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository, CategoryRepository categoryRepository) {
        return args -> {
            categoryRepository.save(new Category(0L, "Bonbons"));
            categoryRepository.save(new Category(1L, "Schokolade"));
            categoryRepository.save(new Category(2L, "Lutscher"));

            productRepository.save(new Product(0L, "Maoam", 500, 10, categoryRepository.findById(0L).orElseThrow()));
            productRepository.save(new Product(1L, "Milka", 100, 5, categoryRepository.findById(1L).orElseThrow()));
            productRepository.save(new Product(2L, "Nimm2 Lutscher", 450, 20, categoryRepository.findById(2L).orElseThrow()));
        };
    }
}