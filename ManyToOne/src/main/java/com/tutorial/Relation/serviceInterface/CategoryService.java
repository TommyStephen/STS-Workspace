package com.tutorial.Relation.serviceInterface;

import java.util.List;

import com.tutorial.Relation.model.Category;
import com.tutorial.Relation.model.CategoryDTO;

public interface CategoryService {

	public List<CategoryDTO> getAllCategories();
	public CategoryDTO createCategory(Category category);
}
