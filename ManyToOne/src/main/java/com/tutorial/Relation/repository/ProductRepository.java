package com.tutorial.Relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.Relation.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
