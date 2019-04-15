package com.syc.book;

import java.sql.SQLException;

import com.syc.book.domain.Order;

/*
 * 订单项的Dao接口
 */
public interface IOrderItemDao {

	public void addOrderItem(Order order) throws SQLException;
}
