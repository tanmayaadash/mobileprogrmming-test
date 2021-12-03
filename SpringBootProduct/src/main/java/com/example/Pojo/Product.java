package com.example.Pojo;

public class Product {
	private int pid;
	private  static int pidCounter = 0;
	private String name,price,description;
	
	public Product( String name, String price, String description) {
		super();
		Product.pidCounter=Product.pidCounter+1;
		this.pid=Product.pidCounter;
		this.name = name;
		this.price = price;
		this.description = description;
		System.out.println("constructor-1");
	}
	public Product(int pid, String name, String price, String description) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.description = description;
		System.out.println("constructor-2");
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
	
	
	
}
