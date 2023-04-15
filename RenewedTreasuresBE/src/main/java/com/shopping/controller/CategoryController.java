package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Category;
import com.shopping.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value="/categorys")
	public List<Category> getCategory(){
		return categoryService.viewAllCategorys();
	}

	@PostMapping(value="/addcategory")
	public void addCategory(@RequestBody Category category) {
		
		categoryService.addCategory(category);
	}
	
	@PutMapping(value="/updatecategory")
	public void updateCategory(@RequestBody Category category) {
		
		categoryService.updateCategory(category);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deletecategory/{id}")
	public void deleteCategory(@PathVariable int id) {
		
		categoryService.deleteCategory(id);
	}
}
