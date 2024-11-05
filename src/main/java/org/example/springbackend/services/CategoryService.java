package org.example.springbackend.services;

import org.example.springbackend.domain.Category;
import org.example.springbackend.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CategoryService(CategoryRepository categoryRepository) {

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
