package com.syc.lucene;

public class Product {

	private Integer id;
	private String name;
	private String desc;

	public Product(Integer id, String name, String desc) {
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public Product() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

}
