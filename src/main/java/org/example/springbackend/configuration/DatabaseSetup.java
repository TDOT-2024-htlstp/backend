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
    CommandLineRunner initOrders(CategoryRepository categoryRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        return args -> {
            var cat = categoryRepository.saveAll(categories);

            var p1 = productRepository.save(new Product(null, "Maoam", 500, 10, cat.getFirst()));
            productRepository.save(new Product(null, "Milka", 100, 5, cat.get(1)));
            productRepository.save(new Product(null, "Nimm2 Lutscher", 450, 20, cat.get(2)));

            var pe = new ProductEntry(null, p1, 5);

            orderRepository.save(new Order(new UUID(1L, 2L), List.of(pe), Status.IN_PROGRESS));
        };
    }
}