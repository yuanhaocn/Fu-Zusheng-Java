package com.syc.book.domain;

/*
 * 订单项,指的是具体的某一个商品.
 */
public class OrderItem {
	private Order order;// 订单项所属的订单
	private Book book;// 所购买的具体商品
	private int buynum;// 购买数量

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

}
