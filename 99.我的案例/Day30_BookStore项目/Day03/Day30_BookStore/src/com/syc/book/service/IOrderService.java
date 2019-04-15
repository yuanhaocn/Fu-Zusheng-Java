package com.syc.book.service;

import java.util.List;

import com.syc.book.domain.Order;
import com.syc.book.exception.OrderException;

/**
 * 订单模块的Service层
 * 
 * @类名称:IOrderService
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午9:52:29
 */
public interface IOrderService {

	public void addOrder(Order order);

	// 修改支付状态
	public void modifyOrderState(String orderId) throws OrderException;

	// 查询某个用户的订单
	public List<Order> findUserOrders(String id) throws OrderException;

	public Order findOrderInfo(String orderId) throws OrderException;
}
