package com.syc.book.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.syc.book.IOrderItemDao;
import com.syc.book.domain.Order;
import com.syc.book.domain.OrderItem;
import com.syc.book.utils.C3P0Util;

/**
 * 添加订单项的具体实现
 * @类名称:OrderItemImpl
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午10:23:03
 */
public class OrderItemDaoImpl implements IOrderItemDao {

	@Override
	public void addOrderItem(Order order) throws SQLException {
		
		QueryRunner qr=new QueryRunner(C3P0Util.getSource());
		String sql="insert into orderitem values(?,?,?)";
		
		List<OrderItem> items = order.getOrderItems();
		Object[][] params=new Object[items.size()][];
		for(int i=0;i<items.size();i++){
			OrderItem item = items.get(i);
			params[i]=new Object[]{order.getId(),item.getBook().getId(),item.getBuynum()};
		}
		
		qr.batch(sql, params);
	}

}
