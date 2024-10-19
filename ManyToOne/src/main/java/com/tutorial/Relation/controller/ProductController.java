package com.tutorial.Relation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tutorial.Relation.model.Product;
import com.tutorial.Relation.model.ProductDTO;
import com.tutorial.Relation.serviceInterface.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
	@Autowired
    private ProductService productService;

    @GetMapping("getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("createProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }
    
    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(@PathVariable long id) {
    	productService.deleteProduct(id);
    }
      

    
}

