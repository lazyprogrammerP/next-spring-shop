package io.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.spring.shop.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
