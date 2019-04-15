package com.syc.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.syc.book.domain.Order;

/***
 * Order的dao层
 * 
 * @类名称:IOrderDao
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午10:15:52
 */
public interface IOrderDao {

	public void addOrder(Order order) throws SQLException;

	public void modifyOrderState(String orderId) throws SQLException;

	public List<Order> findUserOrders(String id) throws SQLException;

	public Order findOrderInfo(String orderId) throws SQLException;
}
