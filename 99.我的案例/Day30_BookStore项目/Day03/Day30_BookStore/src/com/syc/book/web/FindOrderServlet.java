package com.syc.book.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.domain.Order;
import com.syc.book.domain.User;
import com.syc.book.exception.OrderException;
import com.syc.book.service.IOrderService;
import com.syc.book.service.impl.OrderServiceImpl;

/**
 * 查询订单
 * 
 * @类名称:FindOrderServlet
 * @创建人:SYC
 * @创建时间:2017年8月8日 下午2:38:10
 */
public class FindOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			try {
				// 查询出某个用户的订单了
				IOrderService service = new OrderServiceImpl();
				List<Order> orders = service.findUserOrders(user.getId());
				request.setAttribute("orders", orders);
				request.getRequestDispatcher("/orderlist.jsp").forward(request, response);
			} catch (OrderException e) {
				e.printStackTrace();
			}

		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}