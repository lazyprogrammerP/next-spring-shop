package io.spring.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.shop.exception.ThrowableException;
import io.spring.shop.models.Category;
import io.spring.shop.service.CategoryService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/category")
class CategoryController {

    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<Category> addCategory(@Valid @RequestBody final Category category) {
        return ResponseEntity.ok(categoryService.addOrUpdate(category));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable final Long categoryId) {
        if (categoryId == null) {
            throw new ThrowableException(HttpStatus.BAD_REQUEST, "Required variable categoryId is null.");
        }

        categoryService.delete(categoryId);
        return ResponseEntity.ok().build();
    }

}