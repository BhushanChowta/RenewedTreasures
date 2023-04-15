package com.shopping.service;

import java.util.List;

import com.shopping.model.Customer;

public interface CustomerService {

	public List<Customer> viewAllCustomers();	//Read
	
	public void addCustomer(Customer customer);		//Create
	
	public void updateCustomer(Customer customer); //Update
	
	public void deleteCustomer(int id); //Delete
	
	public int loginValidation(String username,String password);	//LoginValidation
}
