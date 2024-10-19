package com.tutorial.Relation.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.tutorial.Relation.model.Product;
import com.tutorial.Relation.model.ProductDTO;
import com.tutorial.Relation.repository.ProductRepository;
import com.tutorial.Relation.serviceInterface.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private ProductRepository productRepository;

	public void setAutoIncrementForProductTableIfNecessary() {
		// Query the maximum ID from the student table
		String checkSql = "SELECT COALESCE(MAX(id), 0) FROM product";
		Long maxId = jdbcTemplate.queryForObject(checkSql, Long.class);

		// Only set AUTO_INCREMENT if the max ID is below 1000
		if (maxId != null && maxId < 1000) {
			String alterSql = "ALTER TABLE product AUTO_INCREMENT = 1001";
			jdbcTemplate.execute(alterSql);
		}	
	}
	
	public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductDTO createProduct(Product product) {
        Product p = productRepository.save(product);
        ProductDTO dto = new ProductDTO();
        dto.setId(p.getId());
        dto.setCategoryId(p.getCategory().getId());
        dto.setName(p.getName());
        dto.setPrice(p.getPrice());
        dto.setUom(p.getUom());
    	
    	return dto;
    }
	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
		
	}
}
