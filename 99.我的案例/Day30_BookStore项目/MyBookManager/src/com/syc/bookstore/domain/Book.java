package com.syc.bookstore.domain;

/**
 * 图书类
 * 
 * @类名称:Book
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午4:41:54
 */
public class Book {

	private String id;//注意为String类型.
	private String name;
	private double price;
	private int pnum;
	private String category;
	private String description;
	private String img_url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

}
