package com.tutorial.Relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.Relation.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

