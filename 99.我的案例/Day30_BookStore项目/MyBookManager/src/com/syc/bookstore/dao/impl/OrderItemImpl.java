package com.syc.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.syc.bookstore.dao.IOrderItemDao;
import com.syc.bookstore.domain.Order;
import com.syc.bookstore.domain.OrderItem;
import com.syc.bookstore.utils.C3P0Util;

/**
 * 订单项添加
 * 
 * @类名称:OrderItemImpl
 * @创建人:SYC
 * @创建时间:2017年7月16日 上午12:45:49
 */
public class OrderItemImpl implements IOrderItemDao {

	@Override
	public void addOrderItem(Order order) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into orderitem values(?,?,?)";

		// 取出该订单中所有的订单项
		List<OrderItem> items = order.getOrderItems();
		Object[][] params = new Object[items.size()][];

		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[] { order.getId(), items.get(i).getBook().getId(), items.get(i).getBuynum() };
		}

		// 批量添加订单项
		qr.batch(sql, params);
	}

}
