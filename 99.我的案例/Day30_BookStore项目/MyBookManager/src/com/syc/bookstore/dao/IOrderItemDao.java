package com.syc.bookstore.dao;

import java.sql.SQLException;

import com.syc.bookstore.domain.Order;

//订单项的接口
public interface IOrderItemDao {

	public void addOrderItem(Order order) throws SQLException;
}
