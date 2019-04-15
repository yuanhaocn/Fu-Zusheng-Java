package com.syc.bookstore.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.syc.bookstore.dao.IOrderDao;
import com.syc.bookstore.domain.Book;
import com.syc.bookstore.domain.Order;
import com.syc.bookstore.domain.OrderItem;
import com.syc.bookstore.utils.C3P0Util;

/**
 * 订单Dao实现
 * 
 * @类名称:OrderDaoImpl
 * @创建人:SYC
 * @创建时间:2017年7月15日 下午11:28:54
 */
public class OrderDaoImpl implements IOrderDao {

	private QueryRunner qr = null;

	public OrderDaoImpl() {
		qr = new QueryRunner(C3P0Util.getDataSource());
	}

	@Override
	public void addOrder(Order order) throws SQLException {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		qr.update(sql, order.getId(), order.getMoney(), order.getReceiverAddress(), order.getReceiverName(),
				order.getReceiverPhone(), order.getPaystate(), order.getOrdertime(), order.getUser().getId());
	}

	@Override
	public List<Order> findUserOrders(int userId) throws SQLException {
		String sql = "select * from orders where user_id=?";
		return qr.query(sql, new BeanListHandler<>(Order.class),userId);
	}

	@Override
	public Order findOrderInfo(String orderId) throws SQLException {
		//查询id=orderId的订单信息
		String sql = "select * from orders where id=?";
		Order order = qr.query(sql, new BeanHandler<>(Order.class),orderId);

		// 查询该订单的所有订单项及书的信息
		// String sql = "select * from book where id in(select book_id from
		// orderitem where order_id=orderid)";
		//book表与orderitem表关联查询.
		String sql2 = "select * from book,orderitem where book.id=orderitem.book_id and orderitem.order_id=?";
		List<OrderItem> items = qr.query(sql2, new ResultSetHandler<List<OrderItem>>() {
			@Override
			public List<OrderItem> handle(ResultSet rs) throws SQLException {
				List<OrderItem> items = new ArrayList<>();
				while (rs.next()) {
					//构建订单项
					OrderItem item = new OrderItem();
					item.setBuynum(rs.getInt("buynum"));
					item.setOrder(order);
					//订单项中的Book
					Book book = new Book();
					book.setName(rs.getString("name"));
					book.setPrice(rs.getDouble("price"));
					item.setBook(book);
					items.add(item);
				}
				return items;
			}
		}, orderId);

		// 设置该订单的订单项
		order.setOrderItems(items);

		return order;
	}

	@Override
	public void modifyOrderState(String orderId) throws SQLException {
		String sql = "update orders set paystate=1 where id=?";
		qr.update(sql, orderId);
	}

}
