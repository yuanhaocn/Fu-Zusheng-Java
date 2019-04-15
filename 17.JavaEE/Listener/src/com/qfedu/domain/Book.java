package com.qfedu.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Book implements HttpSessionBindingListener{
	private String number;
	private String name;
	private Double price;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [number=" + number + ", name=" + name + ", price=" + price + "]";
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
	System.out.println("该对象被绑定到了session对象上");
	
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("该对象从session对象上移除");
	}

}
