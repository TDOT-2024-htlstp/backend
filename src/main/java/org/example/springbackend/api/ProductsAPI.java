package org.example.springbackend.api;

import org.example.springbackend.domain.Product;
import org.example.springbackend.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public record ProductsAPI(ProductService productService) {


    @GetMapping
    private List<Product> allProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    private List<Product> productsByCategory(@PathVariable Long id) {
        return productService.getAllProductsForCategory(id);
    }

}
