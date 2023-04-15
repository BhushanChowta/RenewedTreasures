package com.shopping.service;

import java.util.List;

import com.shopping.model.Category;

public interface CategoryService {
	
	public List<Category> viewAllCategorys();	//Read
	
	public void addCategory(Category category);		//Create
	
	public void updateCategory(Category category); //Update
	
	public void deleteCategory(int id); //Delete

}
