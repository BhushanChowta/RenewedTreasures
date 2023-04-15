package com.shopping.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.model.Category;
import com.shopping.service.CategoryService;
import com.shopping.utils.DButil;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	static List<Category> categoryList=new ArrayList();
	
	Connection connection;


	public CategoryServiceImpl() throws ClassNotFoundException {
	
		connection=DButil.getConnection();
		System.out.println();
	}

	@Override
    public List<Category> viewAllCategorys(){
    	categoryList.clear();
		System.out.println("Inside viewAllCategory");
		String getCategoryQuery="SELECT * FROM CATEGORY";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(getCategoryQuery);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				
				Category cat=new Category();
				cat.setCategoryId(rs.getInt(1));
				cat.setCategoryName(rs.getString(2));
				cat.setCategoryImageUrl(rs.getString(3));
				
				categoryList.add(cat);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return categoryList;
	}
	
	//customer object has informations
	@Override
	public void addCategory(Category category){
		System.out.println("Inside addCategory method");
		int categoryid=category.getCategoryId();
		String categoryname=category.getCategoryName();
		String categoryimageurl=category.getCategoryImageUrl();
		
		String insertQuery="insert into category values("+categoryid+",'"+categoryname+"','"+categoryimageurl+"');";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(insertQuery);
			stmt.executeUpdate();
			System.out.println("Category added successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateCategory(Category category){
		System.out.println("Inside updateCategory method");
		int categoryid=category.getCategoryId();
		String categoryname=category.getCategoryName();
		String categoryimageurl=category.getCategoryImageUrl();
		
		String updateQuery="UPDATE category SET categoryName='"+categoryname+"',categoryImageUrl='"+categoryimageurl+"' where categoryId="+categoryid+";";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(updateQuery);
			stmt.executeUpdate();
			System.out.println("Category updated successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(int id) {
		String deleteQuery="DELETE FROM CATEGORY WHERE categoryId='"+id+"';";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(deleteQuery);
			stmt.executeUpdate();
			System.out.println("Category info Deleted successfully");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	

}