package com.syc.book.domain;

import java.util.Date;
import java.util.List;

/**
 * 订单的JavaBean,一个Order中可以包含N个OrderItem(订单项)
 * 
 * @类名称:Order
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午9:18:30
 */
public class Order {

	private String id;// 订单编号
	private User user;// 订单属于哪个用户
	private double money;// 订单总价
	private String receiverName;// 收货人姓名
	private String receiverAddress;// 收货人地址
	private String receiverPhone;// 收货人电话
	private int paystate;// 支付状态
	private Date ordertime;// 订单时间
	private List<OrderItem> orderItems;// 该订单中包含的所有的订单项

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public int getPaystate() {
		return paystate;
	}

	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
