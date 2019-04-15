package com.syc.product.domain;

public class Product {

	private String id;
	private String pname;
	private String price;
	private String type;

	public Product() {
	}

	public Product(String id, String pname, String price, String type) {
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
