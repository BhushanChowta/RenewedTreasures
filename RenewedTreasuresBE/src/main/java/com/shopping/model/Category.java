package com.shopping.model;

public class Category {
	
	private int categoryId;
	private String categoryName;
	private String categoryImageUrl;
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryImageUrl="
				+ categoryImageUrl + "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryId, String categoryName, String categoryImageUrl) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryImageUrl = categoryImageUrl;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}
	public void setCategoryImageUrl(String categoryImageUrl) {
		this.categoryImageUrl = categoryImageUrl;
	}
	
	
}
