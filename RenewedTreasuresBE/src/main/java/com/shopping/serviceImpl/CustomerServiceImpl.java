package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Customer;
import com.shopping.service.CustomerService;
import com.shopping.utils.DButil;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	static List<Customer> customerList=new ArrayList();
	
	Connection connection;


	public CustomerServiceImpl() throws ClassNotFoundException {
	
		connection=DButil.getConnection();
		System.out.println();
	}

	@Override
    public List<Customer> viewAllCustomers(){
    	customerList.clear();
		System.out.println("Inside viewAllCustomer");
		String getCustomerQuery="SELECT * FROM CUSTOMER";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCustomerQuery);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				
				Customer cust= new Customer();
				cust.setCustomerId(rs.getInt(1));
				cust.setCustomerName(rs.getString(2));
				cust.setGender(rs.getString(3));
				cust.setMailId(rs.getString(4));
				cust.setPhone(rs.getInt(5));
				cust.setAddress(rs.getString(6));
				cust.setUsername(rs.getString(7));
				cust.setPassword(rs.getString(8));
				
				customerList.add(cust);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return customerList;
    }
	
	//customer object has informations
	@Override
	public void addCustomer(Customer customer){
		
		System.out.println("Inside addCustomer method");
		int customerid = customer.getCustomerId();
		String customername = customer.getCustomerName();
		String gender = customer.getGender();
		String mailid = customer.getMailId();
		int phone = customer.getPhone();
		String address = customer.getAddress();
		String username = customer.getUsername();
		String password = customer.getPassword();
		
		String insertQuery = "insert into customer values("+customerid+",'"+customername+"','"+gender+"','"+mailid+"',"+phone+",'"+address+"','"+username+"','"+password+"');";
		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Customer added successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside updateCustomer method");
		int customerid = customer.getCustomerId();
		String customername = customer.getCustomerName();
		String gender = customer.getGender();
		String mailid = customer.getMailId();
		int phone = customer.getPhone();
		String address = customer.getAddress();
		String username = customer.getUsername();
		String password = customer.getPassword();
		
		String updateQuery = "UPDATE customer SET customerName='"+customername+"',gender='"+gender+"',mailId='"+mailid+"',phone="+phone+",address='"+address+"',username='"+username+"',password='"+password+"' WHERE customerId="+customerid+";";
		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Customer info updated successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer(int id) {
		System.out.println("Inside deleteCustomer Method");
		
		String deleteQuery="DELETE FROM CUSTOMER WHERE customerId='"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Customer info Deleted successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public int loginValidation(String username, String password) {
		System.out.println("Inside loginValidation Method");
		int flag=0;
		String loginQuery="SELECT * FROM CUSTOMER WHERE username='"+username+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(loginQuery);
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(7).equals(username)&&rs.getString(8).equals(password)) {
					flag=1;
				}else {
					flag=0;
					System.out.println("Invalid Username/Password");					
				}
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return flag;
	}
	

}