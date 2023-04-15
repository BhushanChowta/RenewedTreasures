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

import com.shopping.model.Customer;
import com.shopping.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/customers")
	public List<Customer> getCustomer(){
		return customerService.viewAllCustomers();
	}

	@PostMapping(value="/addcustomer")
	public void addCustomer(@RequestBody Customer customer) {
		
		customerService.addCustomer(customer);
	}
	
	@PutMapping(value="/updatecustomer")
	public void updateCustomer(@RequestBody Customer customer) {
		
		customerService.updateCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deletecustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		
		customerService.deleteCustomer(id);
	}
	
	@GetMapping(value="/customer/{username}/{password}")
	public int userLogin(@PathVariable("username") String username1,@PathVariable("password") String password1) {
		
		int flag=customerService.loginValidation(username1, password1);
		if(flag==0) {
			return 0;
		}
		return flag;
	}
}