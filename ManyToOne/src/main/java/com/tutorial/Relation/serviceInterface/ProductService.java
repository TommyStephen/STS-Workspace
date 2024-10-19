package com.tutorial.Relation.serviceInterface;

import java.util.List;

import com.tutorial.Relation.model.Product;
import com.tutorial.Relation.model.ProductDTO;


public interface ProductService {

	
	public void setAutoIncrementForProductTableIfNecessary();
	public List<Product> getAllProducts();
	public ProductDTO createProduct(Product product);
	public void deleteProduct(long id);
}
