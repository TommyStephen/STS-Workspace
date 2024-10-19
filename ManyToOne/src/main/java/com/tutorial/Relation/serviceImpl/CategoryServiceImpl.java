package com.tutorial.Relation.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.Relation.model.Category;
import com.tutorial.Relation.model.CategoryDTO;
import com.tutorial.Relation.repository.CategoryRepository;
import com.tutorial.Relation.serviceInterface.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> dtos = new ArrayList<>();
        for(Category category: categoryList) {
        	CategoryDTO dto = new CategoryDTO();
        	dto.setId(category.getId());
        	dto.setCategoryName(category.getCategoryName());
        	dtos.add(dto);
        }
        return dtos;
    }

    public CategoryDTO createCategory(Category category) {
        
    	Category obj = categoryRepository.save(category);
    	CategoryDTO dto = new CategoryDTO();
    	dto.setId(obj.getId());
    	dto.setCategoryName(obj.getCategoryName());
    	
    	return dto;
    }
	    
	    
}
