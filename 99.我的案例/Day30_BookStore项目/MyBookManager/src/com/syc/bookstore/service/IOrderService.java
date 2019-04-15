package com.syc.bookstore.service;

import java.util.List;

import com.syc.bookstore.domain.Order;
import com.syc.bookstore.exception.OrderException;

public interface IOrderService {

	//添加订单
	public void addOrder(Order order);
	
	//根据用户id查找该用户所有的orders
	public List<Order> findUserOrders(int userId);
	
	//根据订单id查找订单信息
	public Order findOrderInfo(String orderId);
	
	//修改订单状态
	public void modifyOrderState(String orderId) throws OrderException;
}
