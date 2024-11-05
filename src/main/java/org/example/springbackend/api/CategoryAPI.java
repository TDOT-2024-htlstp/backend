package org.example.springbackend.api;

import org.example.springbackend.domain.Category;
import org.example.springbackend.services.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public record CategoryAPI(CategoryService categoryService) {

    //get all Categories
    @GetMapping
    private List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

}
