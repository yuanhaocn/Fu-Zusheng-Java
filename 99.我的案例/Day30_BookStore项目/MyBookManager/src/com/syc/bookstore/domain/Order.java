package com.syc.bookstore.domain;

import java.util.Date;
import java.util.List;

/**
 * 订单Bean
 * 
 * @类名称:Order
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午5:14:13
 */
public class Order {

	private String id;// 订单编号
	private User user;// 当前用户
	private double money;// 商品总价
	private String receiverName;// 收件人姓名
	private String receiverAddress;// 收件人地址
	private String receiverPhone;// 收件人电话
	private int paystate;// 支付状态
	private Date ordertime;// 订单时间
	private List<OrderItem> orderItems;// 订单项

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
