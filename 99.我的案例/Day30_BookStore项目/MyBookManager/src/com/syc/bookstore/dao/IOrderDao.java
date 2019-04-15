package com.syc.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.syc.bookstore.domain.Order;

/**
 * 订单的Dao层
 * @类名称:IOrderDao
 * @创建人:SYC
 * @创建时间:2017年7月15日 下午11:28:02
 */
public interface IOrderDao {

	//添加订单
	public void addOrder(Order order) throws SQLException;
	
	//根据用户id查找该用户所有的orders
	public List<Order> findUserOrders(int userId) throws SQLException;
	
	//根据订单id查找订单信息
	public Order findOrderInfo(String orderId) throws SQLException;
	
	//修改订单状态
	public void modifyOrderState(String orderId) throws SQLException;
}
