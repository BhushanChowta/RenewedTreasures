package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Product;
import com.shopping.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/products")
	public List<Product> getProduct(){
		return productService.viewAllProducts();
	}

	@PostMapping(value="/addproduct")
	public void addProduct(@RequestBody Product product) {
		
		productService.addProduct(product);
	}
	
	@PutMapping(value="/updateproduct")
	public void updateProduct(@RequestBody Product product) {
		
		productService.updateProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteproduct/{id}")
	public void deleteProduct(@PathVariable int id) {
		
		productService.deleteProduct(id);
	}
}
