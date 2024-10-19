package com.tutorial.Relation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.Relation.serviceInterface.ProductService;

import jakarta.annotation.PostConstruct;

@Component
public class StartupConfig {

	@Autowired
	private ProductService productService;
	
	@PostConstruct
    public void init() {
        productService.setAutoIncrementForProductTableIfNecessary();
    }
    
}

