package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Product;
import com.shopping.service.ProductService;
import com.shopping.utils.DButil;

@Service
public class ProductServiceImpl implements ProductService{

	static List<Product> productList=new ArrayList();
	
	Connection connection;

	public ProductServiceImpl() throws ClassNotFoundException {
	
		connection=DButil.getConnection();
		System.out.println();
	}

	@Override
	public List<Product> viewAllProducts(){
		productList.clear();
		System.out.println("Inside viewAllProduct");
		String getProductQuery="SELECT * FROM PRODUCT";		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getProductQuery);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				
				Product prod= new Product();
				prod.setProductId(rs.getInt(1));
				prod.setProductName(rs.getString(2));
				prod.setProductPrice(rs.getInt(3));
				prod.setProductDescription(rs.getString(4));
				prod.setImageUrl(rs.getString(5));
				prod.setCategoryId(rs.getInt(6));
				
				productList.add(prod);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return productList;
	}
	
	//Product object has informations
	@Override
	public void addProduct(Product product){
		
		System.out.println("Inside addProduct method");
		int productid=product.getProductId();
		String productname=product.getProductName();
		int productprice=product.getProductPrice();
		String productdescription=product.getProductDescription();
		String imageurl=product.getImageUrl();
		int categoryid=product.getCategoryId();
		
		String insertQry = "insert into product values("+productid+",'"+productname+"',"+productprice+",'"+productdescription+"','"+imageurl+"',"+categoryid+");";

		try {
			PreparedStatement stmt = connection.prepareStatement(insertQry);
			stmt.executeUpdate();
			System.out.println("Product added successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateProduct(Product product){
		
		System.out.println("Inside updateProduct method");
		int productid=product.getProductId();
		String productname=product.getProductName();
		int productprice=product.getProductPrice();
		String productdescription=product.getProductDescription();
		String imageurl=product.getImageUrl();
		int categoryid=product.getCategoryId();
		
		String updateQuery = "UPDATE product set productName='"+productname+"',productprice="+productprice+",productdescription='"+productdescription+"',imageurl='"+imageurl+"',categoryid="+categoryid+" where productId="+productid+";";
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Product info updated successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(int id) {
		String deleteQuery="DELETE FROM PRODUCT WHERE productId='"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Product info Deleted successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
}
