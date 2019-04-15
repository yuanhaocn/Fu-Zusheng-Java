package com.syc.bookstore.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.domain.Order;
import com.syc.bookstore.domain.OrderItem;
import com.syc.bookstore.domain.User;
import com.syc.bookstore.service.IOrderService;
import com.syc.bookstore.service.impl.OrderServiceImpl;

/**
 * 订单Servlet
 * 
 * @类名称:OrderServlet
 * @创建人:SYC
 * @创建时间:2017年7月15日 下午10:48:50
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);

		try {
			// 创建订单对象
			Order order = new Order();
			// 填充订单内容
			BeanUtils.populate(order, request.getParameterMap());
			order.setId(UUID.randomUUID().toString());
			// 设置订单所属用户
			order.setUser((User) request.getSession().getAttribute("user"));

			// 订单项集合
			List<OrderItem> items = new ArrayList<>();
			// 得到购物车
			Map<Book, String> cartMap = (Map<Book, String>) request.getSession().getAttribute("cart");
			// 遍历购物车,将购物车中的每一项都封装为一个订单项
			for (Book book : cartMap.keySet()) {
				// 封装订单项
				OrderItem item = new OrderItem();
				item.setBook(book);
				item.setBuynum(Integer.parseInt(cartMap.get(book)));
				item.setOrder(order);
				// 将每个订单项都添加进集合中
				items.add(item);
			}

			// 设置订单的订单项
			order.setOrderItems(items);

			// 将订单信息存储到数据库
			IOrderService service = new OrderServiceImpl();
			service.addOrder(order);

			//跳转到支付页面
			request.setAttribute("orderId", order.getId());
			request.setAttribute("money", order.getMoney());
			request.getRequestDispatcher("/pay.jsp").forward(request, response);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
