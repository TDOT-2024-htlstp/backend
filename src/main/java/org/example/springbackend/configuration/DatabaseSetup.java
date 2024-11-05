package org.example.springbackend.configuration;

import org.example.springbackend.domain.*;
import org.example.springbackend.repositories.CategoryRepository;
import org.example.springbackend.repositories.OrderRepository;
import org.example.springbackend.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class DatabaseSetup {

    static List<Category> categories = List.of(new Category(null, "Bonbons"), new Category(null, "Schokolade"), new Category(null, "Lutscher"));


    @Bean
    CommandLineRunner initCategories(CategoryRepository categoryRepository) {
        return args -> categoryRepository.saveAll(categories);
    }

    @Bean
    CommandLineRunner initProducts(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product(null, "Maoam", 500, 10, categories.getFirst()));
            productRepository.save(new Product(null, "Milka", 100, 5, categories.get(1)));
            productRepository.save(new Product(null, "Nimm2 Lutscher", 450, 20, categories.get(2)));
        };
    }

    @Bean
    CommandLineRunner initOrders(OrderRepository orderRepository) {
        return args -> orderRepository.save(new Order(new UUID(1L,2L),null, Status.IN_PROGRESS));
    }
}