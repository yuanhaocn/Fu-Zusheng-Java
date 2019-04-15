package com.syc.book.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.syc.book.domain.Book;
import com.syc.book.domain.Order;
import com.syc.book.domain.OrderItem;
import com.syc.book.domain.User;
import com.syc.book.service.IOrderService;
import com.syc.book.service.impl.OrderServiceImpl;

/**
 * 处理Order订单的Servlet
 * 
 * @类名称:OrderServlet
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午9:36:07
 */
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			User user = (User) request.getSession().getAttribute("user");
			if (user != null) {
				Order order = new Order();
				order.setId(UUID.randomUUID().toString());
				order.setUser(user);

				// 从购物车中取出集合
				Map<Book, String> cartMap = (Map<Book, String>) request.getSession().getAttribute("cart");
				List<OrderItem> items = new ArrayList<>();
				if (cartMap != null) {
					for (Book book : cartMap.keySet()) {
						OrderItem item = new OrderItem();
						item.setBook(book);
						item.setOrder(order);
						int buyCount = Integer.parseInt(cartMap.get(book));
						item.setBuynum(buyCount);
						items.add(item);
					}
				}
				order.setOrderItems(items);

				BeanUtils.populate(order, request.getParameterMap());

				// 将该订单信息存放到数据库中
				IOrderService service = new OrderServiceImpl();
				service.addOrder(order);

				// 跳转到支付页面
				request.setAttribute("orderId", order.getId());
				request.setAttribute("money", order.getMoney());
				request.getRequestDispatcher("/pay.jsp").forward(request, response);
			} else {
				// 如果没有登陆,则进入到登陆页面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}