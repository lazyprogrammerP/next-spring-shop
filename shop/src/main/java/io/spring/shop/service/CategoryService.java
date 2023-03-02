package io.spring.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.shop.models.Category;
import io.spring.shop.repository.CategoryRepository;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category addOrUpdate(final Category category) {
        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    public void delete(final Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
