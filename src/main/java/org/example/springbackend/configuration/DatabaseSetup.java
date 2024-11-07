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

    @Bean
    CommandLineRunner initOrders(CategoryRepository categoryRepository, OrderRepository orderRepository, ProductRepository productRepository) {
        return args -> {
            var categories = List.of(
                    new Category(null, "Bonbons"),
                    new Category(null, "Schokolade"),
                    new Category(null, "Lutscher")
            );

            categories = categoryRepository.saveAll(categories);

            var products = List.of(
                    new Product(null, "Maoam Cola", 10, 20, "api/images/maoam/cola.png", categories.getFirst()),
                    new Product(null, "Maoam Erdbeere", 10, 20, "api/images/maoam/erdbeere.png", categories.getFirst()),
                    new Product(null, "Maoam Himbeere", 10, 20, "api/images/maoam/himbeere.png", categories.getFirst()),
                    new Product(null, "Maoam Orange", 10, 20, "api/images/maoam/orange.png", categories.getFirst()),
                    new Product(null, "Maoam Zitrone", 10, 20, "api/images/maoam/zitrone.png", categories.getFirst()),

                    new Product(null, "Milka Mini", 10, 20, "api/images/milka/minis.png", categories.get(1)),

                    new Product(null, "Nimm 2 Lollipop", 30, 20, "api/images/nimm2/lolli.png", categories.get(2))
            );

            products = productRepository.saveAll(products);

            var productEntries = List.of(
                    new ProductEntry(null, products.get(2), 6),
                    new ProductEntry(null, products.get(4), 7),
                    new ProductEntry(null, products.get(3), 2),
                    new ProductEntry(null, products.get(2), 3),
                    new ProductEntry(null, products.get(0), 5),
                    new ProductEntry(null, products.get(1), 2)
            );

            orderRepository.save(new Order(null, productEntries.subList(0, 4), Status.IN_PROGRESS));
            orderRepository.save(new Order(null, productEntries.subList(4, 6), Status.IN_PROGRESS));
        };
    }
}