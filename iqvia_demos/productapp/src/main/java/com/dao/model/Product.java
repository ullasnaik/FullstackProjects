package com.dao.model;

public class Product {

	private int prodCode;
	private String name;
	private String category;
	private double price;

	public Product() {
	}

	public Product(int prodCode, String name, String category, double price) {
		super();
		this.prodCode = prodCode;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProdCode() {
		return prodCode;
	}

	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
