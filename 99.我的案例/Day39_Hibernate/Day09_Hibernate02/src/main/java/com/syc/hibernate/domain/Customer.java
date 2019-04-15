package com.syc.hibernate.domain;

import java.util.Set;

/*
 * 一对多关系中的单方
 */
public class Customer {

	private int id;
	private String name;

	private Set<Order> orders;//体现与Order类的关系

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
