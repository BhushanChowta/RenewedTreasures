package com.shopping.service;

import java.util.List;

import com.shopping.model.Product;

public interface ProductService {
	
	public List<Product> viewAllProducts();	//Read
		
	public void addProduct(Product product);		//Create
		
	public void updateProduct(Product product); //Update
	
	public void deleteProduct(int id); //Delete	
}
