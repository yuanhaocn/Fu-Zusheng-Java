package com.syc.bookstore.domain;

/**
 * 订单项Bean
 * 
 * @类名称:OrderItem
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午5:18:32
 */
public class OrderItem {

	private Order order;// 订单信息
	private int buynum;// 购买数量
	private Book book;// 购买的图书

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
