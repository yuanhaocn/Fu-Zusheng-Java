package com.syc.book.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.syc.book.dao.IOrderDao;
import com.syc.book.domain.Book;
import com.syc.book.domain.Order;
import com.syc.book.domain.OrderItem;
import com.syc.book.utils.C3P0Util;

/**
 * Order的dao层具体实现
 * 
 * @类名称:OrderDaoImpl
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午10:16:46
 */
public class OrderDaoImpl implements IOrderDao {

	private QueryRunner qr = null;

	public OrderDaoImpl() {
		qr = new QueryRunner(C3P0Util.getSource());
	}

	@Override
	public void addOrder(Order order) throws SQLException {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		qr.update(sql, order.getId(), order.getMoney(), order.getReceiverAddress(), order.getReceiverName(),
				order.getReceiverPhone(), order.getPaystate(), order.getOrdertime(), order.getUser().getId());
	}

	// 修改订单支付状态
	@Override
	public void modifyOrderState(String orderId) throws SQLException {
		String sql = "update orders set paystate=1 where id=?";
		qr.update(sql, orderId);
	}

	@Override
	public List<Order> findUserOrders(String userId) throws SQLException {
		String sql = "select * from orders where user_id=?";
		return qr.query(sql, new BeanListHandler<>(Order.class), userId);
	}

	// 查询订单信息
	@Override
	public Order findOrderInfo(String orderId) {
		try {
			String sql = "select * from orders where id=?";
			Order order = qr.query(sql, new BeanHandler<>(Order.class), orderId);

			String sql2 = "select * from book,orderitem where book.id=orderitem.book_id and orderitem.order_id=?";

			// 复写handle方法,目的在在于我们要手动的封装List<OrderItem>集合.
			List<OrderItem> items = qr.query(sql2, new ResultSetHandler<List<OrderItem>>() {

				@Override
				public List<OrderItem> handle(ResultSet set) throws SQLException {
					List<OrderItem> items = new ArrayList<>();

					while (set.next()) {
						OrderItem item = new OrderItem();
						item.setOrder(order);
						item.setBuynum(set.getInt("buynum"));
						Book book = new Book();
						book.setId(set.getString("id"));
						book.setName(set.getString("name"));
						book.setPrice(set.getDouble("price"));
						item.setBook(book);
						items.add(item);
					}

					return items;
				}

			}, orderId);

			order.setOrderItems(items);
			return order;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
