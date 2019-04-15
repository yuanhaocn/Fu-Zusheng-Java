package com.syc.book.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.syc.book.IOrderItemDao;
import com.syc.book.dao.IBookDao;
import com.syc.book.dao.IOrderDao;
import com.syc.book.dao.impl.BookDaoImpl;
import com.syc.book.dao.impl.OrderDaoImpl;
import com.syc.book.dao.impl.OrderItemDaoImpl;
import com.syc.book.domain.Order;
import com.syc.book.exception.OrderException;
import com.syc.book.service.IOrderService;
import com.syc.book.utils.C3P0Util;

/**
 * Service层中订单模块的实现
 * 
 * @类名称:OrderServiceImpl
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午9:53:31
 */
public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao = new OrderDaoImpl();
	private IOrderItemDao orderItemDao = new OrderItemDaoImpl();
	private IBookDao bookDao = new BookDaoImpl();

	@Override
	public void addOrder(Order order) {
		Connection conn = null;
		try {
			conn = C3P0Util.getConnection();

			// 1.关闭事务的自动提交功能,相当于开启事务.
			conn.setAutoCommit(false);

			// 进行具体的业务
			// 要涉及到3张表的操作:order表,orderItem表,book表
			orderDao.addOrder(order);
			orderItemDao.addOrderItem(order);
			bookDao.updateBookNum(order);

		} catch (SQLException e) {
			e.printStackTrace();

			// 2.设置事务的回滚
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			// 3.提交事务
			try {
				conn.commit();
				C3P0Util.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void modifyOrderState(String orderId) throws OrderException {
		try {
			orderDao.modifyOrderState(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> findUserOrders(String id) {
		try {
			return orderDao.findUserOrders(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order findOrderInfo(String orderId) throws OrderException {
		try {
			return orderDao.findOrderInfo(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
