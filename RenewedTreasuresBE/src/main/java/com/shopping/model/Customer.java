package com.shopping.model;

public class Customer {

	private int customerId;
	private String customerName;
	private String gender;
	private String mailId;
	private int phone;
	private String address;
	private String username;
	private String password;
	
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", mailId=" + mailId + ", phone=" + phone + ", address=" + address + ", username=" + username
				+ ", password=" + password + "]";
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int customerId, String customerName, String gender, String mailId, int phone, String address,
			String username, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.mailId = mailId;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username =username;
		
	}
	
	
}