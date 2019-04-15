package com.syc.bookstore.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.syc.bookstore.dao.IBookDao;
import com.syc.bookstore.dao.IOrderDao;
import com.syc.bookstore.dao.IOrderItemDao;
import com.syc.bookstore.dao.impl.BookDaoImpl;
import com.syc.bookstore.dao.impl.OrderDaoImpl;
import com.syc.bookstore.dao.impl.OrderItemImpl;
import com.syc.bookstore.domain.Order;
import com.syc.bookstore.exception.OrderException;
import com.syc.bookstore.service.IOrderService;
import com.syc.bookstore.utils.C3P0Util;

/**
 * 订单Service
 * 
 * @类名称:OrderServiceImpl
 * @创建人:SYC
 * @创建时间:2017年7月15日 下午11:20:40
 */
public class OrderServiceImpl implements IOrderService {

	private IBookDao bookDao = new BookDaoImpl();

	private IOrderDao orderDao = new OrderDaoImpl();

	private IOrderItemDao orderItemDao = new OrderItemImpl();

	@Override
	public void addOrder(Order order) {
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();
			// 开启事务
			conn.setAutoCommit(false);
			//添加订单信息到数据库
			orderDao.addOrder(order);
			orderItemDao.addOrderItem(order);
			// 订单提交成功后,库存减少,修改图书数量.
			bookDao.updateBooksNum(order);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				// 事务回滚
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// 事务提交
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Order> findUserOrders(int userId) {
		try {
			return orderDao.findUserOrders(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order findOrderInfo(String orderId) {
		try {
			return orderDao.findOrderInfo(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modifyOrderState(String orderId) throws OrderException {
		try {
			orderDao.modifyOrderState(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new OrderException("订单状态修改失败!");
		}
	}

}
